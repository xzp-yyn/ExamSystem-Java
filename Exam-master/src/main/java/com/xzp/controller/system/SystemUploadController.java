package com.xzp.controller.system;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.UUID;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.xzp.other.result.BaseResult;
import com.xzp.other.utils.GiteeImgBed;
import com.xzp.other.utils.MyData;
import com.xzp.service.MyUploadService;
import com.xzp.service.QuestionService;

import com.xzp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统上传控制器
 *
 * @author 薛展鹏
 * @date 2023/03/21
 */
@Controller
@RequestMapping("/system/upload")
public class SystemUploadController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @Autowired
    MyUploadService myUploadService;

    /**
     * 上传img
     * 上传图片
     * @return {@link String}
     * @throws Exception 异常
     */
    @PostMapping("/uploadImage")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public BaseResult uploadImg(@RequestParam("file") MultipartFile file) throws Exception {
        logger.info("请求成功");
        String originaFileName = file.getOriginalFilename();
        //上传图片不存在时
        if(originaFileName == null){
            return BaseResult.errorMsg("上传图片不存在时");
        }

        String suffix = ".jpg";
        //设置图片名字
        String fileName = System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + suffix;

        String paramImgFile = Base64.encode(file.getBytes());
        //设置转存到Gitee仓库参数
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("access_token", GiteeImgBed.ACCESS_TOKEN);
        paramMap.put("message", GiteeImgBed.ADD_MESSAGE);
        paramMap.put("content", paramImgFile);

        //转存文件路径
        String targetDir = GiteeImgBed.PATH + fileName;
        //设置请求路径
        String requestUrl = String.format(GiteeImgBed.CREATE_REPOS_URL, GiteeImgBed.OWNER,
                GiteeImgBed.REPO_NAME, targetDir);
        logger.info("请求Gitee仓库路径:{}",requestUrl);

        String resultJson = HttpUtil.post(requestUrl, paramMap);
        JSONObject jsonObject = JSONUtil.parseObj(resultJson);
        //表示操作失败
        if (jsonObject==null || jsonObject.getObj("commit") == null) {
            return BaseResult.errorMsg("操作失败");
        }
        JSONObject content = JSONUtil.parseObj(jsonObject.getObj("content"));

        return BaseResult.successData(content.getObj("download_url"));
    }


    /**
     * 删除图片
     * @param imgPath
     * @return
     * @throws Exception
     */
    @DeleteMapping("/delImg")
    @ResponseBody
    public BaseResult delImg(@RequestParam(value = "imgPath") String imgPath) throws Exception {
        //路径不存在不存在时
        if(imgPath == null || imgPath.trim().equals("")){
            return BaseResult.errorMsg("删除失败");
        }
        String path = imgPath.split("master/")[1];
        //上传图片不存在时
        if(path == null || path.trim().equals("")){
            return BaseResult.errorMsg("上传图片不存在");
        }
        //设置请求路径
        String requestUrl = String.format(GiteeImgBed.GET_IMG_URL, GiteeImgBed.OWNER,
                GiteeImgBed.REPO_NAME, path);
        logger.info("请求Gitee仓库路径:{}",requestUrl);

        //获取图片所有信息
        String resultJson = HttpUtil.get(requestUrl);

        JSONObject jsonObject = JSONUtil.parseObj(resultJson);
        if (jsonObject == null) {
            logger.error("Gitee服务器未响应,message:{}",jsonObject);
            return BaseResult.errorMsg("Gitee服务器未响应");
        }
        //获取sha,用于删除图片
        String sha = jsonObject.getStr("sha");
        //设置删除请求参数
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("access_token", GiteeImgBed.ACCESS_TOKEN);
        paramMap.put("sha", sha);
        paramMap.put("message", GiteeImgBed.DEl_MESSAGE);
        //设置删除路径
        requestUrl = String.format(GiteeImgBed.DEL_IMG_URL, GiteeImgBed.OWNER,
                GiteeImgBed.REPO_NAME, path);
        logger.info("请求Gitee仓库路径:{}",requestUrl);
        //删除文件请求路径
        resultJson = HttpRequest.delete(requestUrl).form(paramMap).execute().body();
        HttpRequest.put(requestUrl).form(paramMap).execute().body();
        jsonObject = JSONUtil.parseObj(resultJson);
        //请求之后的操作
        if(jsonObject.getObj("commit") == null){
            logger.error("Gitee服务器未响应,message:{}",jsonObject);
            return BaseResult.errorMsg("Gitee服务器未响应");
        }
        return BaseResult.successMsg("删除成功");
    }

    /**
     * 上传Excel
     * @param req
     * @return
     */
    @RequestMapping("/uploadExcel")
    @ResponseBody
    public BaseResult uploadExcel(HttpServletRequest req){
        // 上传到本地
        String fileName = myUploadService.uploadLocal(req, "excel").get("fileName");
        String path = MyData.resourcePath + "/excel/" + fileName;
        questionService.importExcel(path);
        // 删除该文件
        File file = new File(path);
        file.delete();
        return BaseResult.boolResult(true);
    }
}
