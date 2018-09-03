package com.dzqd.comondao.controller;

import com.dzqd.comondao.base.SupperMapper;
import com.dzqd.comondao.dao.UserRoleMapper;
import com.dzqd.comondao.entity.UserRoleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Winston Yang
 * @Date: Create in 10:03 2018/8/22
 * @Modified by:
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController extends  BaseController<UserRoleDO> {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    protected SupperMapper<UserRoleDO> getMapper() {
        return userRoleMapper;
    }
}
