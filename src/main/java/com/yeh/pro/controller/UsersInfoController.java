package com.yeh.pro.controller;

import com.yeh.pro.entity.StuInfoEntity;
import com.yeh.pro.entity.UsersInfoEntity;
import com.yeh.pro.service.StuInfoService;
import com.yeh.pro.service.impl.StuInfoServiceImpl;
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
    StuInfoServiceImpl stuInfoService;

    @Autowired
    public void setPersonInfoService(UsersInfoServiceImpl usersInfoService) {
        this.usersInfoService = usersInfoService;
    }
    @Autowired
    public void setStuInfoService(StuInfoServiceImpl stuInfoService){
        this.stuInfoService=stuInfoService;
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
     * 根据机构编号找到属于该机构的所有用户基本信息
     */
    @ResponseBody
    @GetMapping("/getUsersInfoByOrgId/{mechanism_id},{user_grade}")
    List<UsersInfoEntity> getUsersInfoByOrgId(@PathVariable int mechanism_id, @PathVariable int user_grade){
        return usersInfoService.getUsersInfoByOrgId(mechanism_id,user_grade);
    }

    /**
     * 根据机构编号找到属于该机构的所有用户所有信息
     */
    @ResponseBody
    @GetMapping("/getUsersAllInfoByOrgId/{mechanism_id},{user_grade}")
    List<StuInfoEntity> getUsersAllInfoByOrgId(@PathVariable int mechanism_id, @PathVariable int user_grade){
        return stuInfoService.getUsersAllInfoByOrgId(mechanism_id, user_grade);
    }

    /**
     * 添加一个用户
     */
    @ResponseBody
    @RequestMapping("/addUserInfo")
    Integer addUserInfo(@RequestBody UsersInfoEntity usersInfoEntity){
        return usersInfoService.addUserInfo(usersInfoEntity);
    }

    /**
     * 更新一个用户信息
     */
    @ResponseBody
    @RequestMapping("/updateUserInfo")
    int updateUserInfo(@RequestBody UsersInfoEntity usersInfoEntity){
        return usersInfoService.updateUserInfo(usersInfoEntity);
    }

    /**
     * 删除一个用户信息
     */
    @ResponseBody
    @GetMapping("/deleteUserInfo/{id}")
    int deleteUserInfo(@PathVariable Integer id){
        return usersInfoService.deleteUserInfo(id);
    }
}
