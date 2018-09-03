package com.dzqd.comondao.controller;

import com.dzqd.comondao.dao.RoleMapper;
import com.dzqd.comondao.entity.RoleDO;
import com.dzqd.comondao.service.RoleService;
import com.dzqd.comondao.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Winston Yang
 * @Date: Create in 15:54 2018/8/15
 * @Modified by:
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<RoleDO>{
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleService roleService;

    protected RoleMapper getMapper(){
        return  roleMapper;
    }

    /**
     *  删除角色
     *  1: 删除角色  2:删除角色对应权限  3:删除用户对应的角色
     *  涉及两张表    role   role_permi   user_role
     *  TIP:
     *  //@Transactional  事务开启不能加载controller层   必须加在service层
     *   因为本项目使用AOP实现动态切换数据源  切点是controller的每个方法 在controller上加入@Transactional
     *   是在获取数据源之后开启, 后面的数据库操作都会导致报错!!
     *   所以@Transactional 必须在controller  AOP执行后再加载
     * @param id
     * @return
     */
    @Override
    //@Transactional
    @PostMapping("/deleteById/{id}")
    public ResultVo delete(@PathVariable("id") Integer id) {
        log.info("start delete role ==----  "+id);

        return roleService.delete(id);
    }
}
