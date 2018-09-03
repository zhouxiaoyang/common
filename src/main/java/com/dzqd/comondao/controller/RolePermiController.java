package com.dzqd.comondao.controller;

import com.dzqd.comondao.base.SupperMapper;
import com.dzqd.comondao.dao.RolePermiMapper;
import com.dzqd.comondao.entity.RolePermiDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Winston Yang
 * @Date: Create in 10:01 2018/8/22
 * @Modified by:
 */
@RestController
@RequestMapping("/rolePermi")
public class RolePermiController extends BaseController<RolePermiDO> {

    @Autowired
    RolePermiMapper rolePermiMapper;

    @Override
    protected SupperMapper<RolePermiDO> getMapper() {
        return rolePermiMapper;
    }
}
