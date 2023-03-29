package com.xzp.controller.student;

import com.xzp.controller.admin.AdminRecordController;
import com.xzp.other.result.BaseResult;
import com.xzp.pojo.dto.QueryPageRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 学生考试记录控制器
 *
 * @author 薛展鹏
 * @date 2023/03/21
 */
@RestController
@RequestMapping("/student/record")
public class StudentRecordController {

    @Autowired
    AdminRecordController adminRecordController;

    @GetMapping("/queryPage")
    public BaseResult queryPage(QueryPageRecordDTO queryPageRecordDTO) {
        return adminRecordController.queryPage(queryPageRecordDTO);
    }

}
