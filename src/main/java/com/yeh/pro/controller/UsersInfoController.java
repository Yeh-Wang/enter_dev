package com.yeh.pro.controller;

import com.yeh.pro.entity.UsersInfoEntity;
import com.yeh.pro.service.impl.UsersInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
@RestController
@RequestMapping("/users-info-entity")
public class UsersInfoController {

    //注入服务
    UsersInfoServiceImpl usersInfoService;

    @Autowired
    public void setPersonInfoService(UsersInfoServiceImpl usersInfoService) {
        this.usersInfoService = usersInfoService;
    }

    /**
     * 登录验证
     */
    @ResponseBody
    @GetMapping("/judgeLogin/{username},{password},{grade}")
    public String judgeLogin(@PathVariable String username, @PathVariable String password, @PathVariable int grade) {
        if (Objects.equals(usersInfoService.judgeUsername(username), "1")) {
            if (Objects.equals(usersInfoService.judgeUserPwd(password), "1")) {
                if (Objects.equals(usersInfoService.judgeUserGrade(grade,username,password), "1")) {
                    return usersInfoService.getId(grade,username,password)+"";
                } else {
                    return usersInfoService.judgeUserGrade(grade,username,password);
                }
            } else {
                return usersInfoService.judgeUserPwd(password);
            }
        } else {
            return usersInfoService.judgeUsername(username);
        }
    }

    /**
     * 根据id查找用户信息
     */
    @ResponseBody
    @GetMapping("/getUserInfoById/{id}")
    UsersInfoEntity getUserInfoById(@PathVariable int id){
        return usersInfoService.getUserInfoById(id);
    }

    /**
     * 根据机构编号找到属于该机构的所有用户信息
     */
    @ResponseBody
    @GetMapping("/getUsersInfoByOrgId/{mechanism_id},{user_grade}")
    List<UsersInfoEntity> getUsersInfoByOrgId(@PathVariable int mechanism_id, @PathVariable int user_grade){
        return usersInfoService.getUsersInfoByOrgId(mechanism_id,user_grade);
    }
}
