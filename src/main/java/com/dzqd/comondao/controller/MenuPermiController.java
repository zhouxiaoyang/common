package com.dzqd.comondao.controller;

import com.dzqd.comondao.base.SupperMapper;
import com.dzqd.comondao.dao.MenuPermiMapper;
import com.dzqd.comondao.entity.MenuPermiDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Winston Yang
 * @Date: Create in 10:00 2018/8/22
 * @Modified by:
 */
@RestController
@RequestMapping("/menuPermi")
public class MenuPermiController extends BaseController<MenuPermiDO>{

    @Autowired
    MenuPermiMapper menuPermiMapper;

    @Override
    protected SupperMapper<MenuPermiDO> getMapper() {
        return menuPermiMapper;
    }
}
