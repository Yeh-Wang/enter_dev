package com.yeh.pro.controller;

import com.yeh.pro.entity.organizationInfo;
import com.yeh.pro.mapper.organizationInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Yaxin-Wang
 * @date : 2023/2/6
 */
@RestController
@RequestMapping("/organization-info-entity")
public class organizationInfoController {

    private organizationInfoMapper infoMapper;

    @Autowired
    public void setInfoMapper(organizationInfoMapper infoMapper) {
        this.infoMapper = infoMapper;
    }

    /**
     * get organization information
     */
    @ResponseBody
    @GetMapping("/getOrgInfoById/{id}")
    organizationInfo getOrgInfoById(@PathVariable Integer id){
        return infoMapper.selectById(id);
    }

    /**
     * update organization information
     */
    @ResponseBody
    @PostMapping("/updateOrgInfo")
    Integer updateOrgInfo(@RequestBody organizationInfo info){
        return infoMapper.updateById(info);
    }
}
