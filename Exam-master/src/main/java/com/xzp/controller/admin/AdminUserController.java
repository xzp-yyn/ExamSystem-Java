package com.xzp.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzp.other.result.BaseResult;
import com.xzp.other.result.PageResult;
import com.xzp.pojo.dto.QueryPageUserDTO;
import com.xzp.pojo.enums.RoleEnum;
import com.xzp.pojo.po.User;
import com.xzp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


/**
 * 管理用户控制器
 *
 * @author 薛展鹏
 * @date 2023/03/21
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    UserService userService;

    /**
     * 获取数量
     * @return 记录数量
     */
    @GetMapping(value = "/getCount")
    public BaseResult getCount(){
        return BaseResult.successData(userService.count());
    }

    /**
     * 查询所有
     * @return 对象列表
     */
    @GetMapping(value = "/queryAll")
    public PageResult queryAll(){
        List<User> list = userService.list();
        return PageResult.success((long) list.size(), list);
    }

    /**
     * 查询所有学生
     * @return 对象列表
     */
//    @GetMapping(value = "/queryAllStudents")
//    public PageResult queryAllStudents(){
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("role", 1); // 条件是学生
//        List<User> list = userService.list(queryWrapper);
//        return PageResult.success((long) list.size(), list);
//    }

    /**
     * 查询分页
     * @param queryPageUserDTO 查询参数
     * @return 分页结果集
     */
    @GetMapping(value = "/queryPage")
    public PageResult queryPage(QueryPageUserDTO queryPageUserDTO){
        // 获取分页对象
        Page<User> page = new Page<>(queryPageUserDTO.getPage(), queryPageUserDTO.getLimit());
        // 模糊查询用户名
        String username = queryPageUserDTO.getUsername();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "username", username);
        Page<User> resPage = userService.page(page, queryWrapper);
        return PageResult.success(resPage.getTotal(), resPage.getRecords());
    }

    /**
     * 添加一个
     * @param user 对象
     * @return 是否成功
     */
    @PostMapping(value = "/addOne")
    public BaseResult addOne(@RequestBody User user){
        User oldUser = userService.checkExistsUsername(user.getUsername());
        if (oldUser != null) return BaseResult.errorMsg("用户名已存在，请更换用户名!");
        return BaseResult.boolResult(userService.save(user));
    }

    /**
     * 删除一个
     * @param user 对象
     * @return 是否成功
     */
    @DeleteMapping(value = "/deleteOne")
    public BaseResult deleteOne(@RequestBody User user){
        try {
            userService.deleteUser(user);
        } catch (Exception e) {
            return BaseResult.errorException(e);
        }
        return BaseResult.boolResult(true);
    }

    /**
     * 删除一些
     * @param users 对象列表
     * @return 是否成功
     */
    @DeleteMapping(value = "/deleteSome")
    public BaseResult deleteSome(@RequestBody List<User> users){
        int successCount = 0, failureCount = 0;
        for (User user : users) {
            try {
                userService.deleteUser(user);
                successCount++;
            } catch (Exception e) {
                failureCount++;
            }
        }
        if (users.size() == successCount) {
            return BaseResult.boolResult(true);
        } else {
            return BaseResult.errorMsg("成功【" + successCount + "】个，失败【" + failureCount + "】个");
        }
    }

    /**
     * 更新一个
     * @param user 对象
     * @return 是否成功
     */
    @PutMapping(value = "/updateOne")
    public BaseResult updateOne(@RequestBody User user){
        User oldUser = userService.checkExistsUsername(user.getUsername());
        if (user.getId() == 1 && user.getRole() .equals( RoleEnum.STUDENT.getRole())) {
            return BaseResult.errorMsg("主管理员不能修改身份");
        }
        if (oldUser != null && !Objects.equals(oldUser.getId(), user.getId())){
            return BaseResult.errorMsg("用户名已存在，请更换用户名!");
        }
        return BaseResult.boolResult(userService.updateById(user));
    }

}
