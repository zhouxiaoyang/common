package com.dzqd.comondao.controller;


import com.dzqd.comondao.base.SupperMapper;

import com.dzqd.comondao.dao.PermiMapper;
import com.dzqd.comondao.entity.PermiDO;
import com.dzqd.comondao.service.PermiService;
import com.dzqd.comondao.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 权限的crud
 * @Author: Winston Yang
 * @Date: Create in 15:55 2018/8/15
 * @Modified by:
 */
@RestController
@RequestMapping("/permi")
public class PermiController extends BaseController<PermiDO>{

    @Autowired
    PermiMapper permiMapper;

    @Autowired
    PermiService permiService;

    @Autowired

    @Override
    protected SupperMapper<PermiDO> getMapper() {
        return permiMapper;
    }

    /**
     *  删除权限时
     *  1:删除权限  2:删除权限对应的菜单权限  3:删除角色中所有该权限
     *  涉及三张表    permi   menu_permi     role_permi
     * @param id
     * @return
     */
    @Override
   // @Transactional(rollbackFor = Exception.class)
    @PostMapping("/deleteById/{id}")
    public ResultVo delete(@PathVariable("id") Integer id) {

        log.info("start delete permi =="+id);

        return permiService.delete(id);
    }
}
