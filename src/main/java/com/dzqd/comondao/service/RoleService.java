package com.dzqd.comondao.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dzqd.comondao.dao.RoleMapper;
import com.dzqd.comondao.dao.RolePermiMapper;
import com.dzqd.comondao.dao.UserRoleMapper;
import com.dzqd.comondao.entity.RolePermiDO;
import com.dzqd.comondao.entity.UserRoleDO;
import com.dzqd.comondao.util.ResultVoUtil;
import com.dzqd.comondao.vo.ResultVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: Winston Yang
 * @Date: Create in 17:18 2018/8/20
 * @Modified by:
 */
@Service
@Log
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RolePermiMapper rolePermiMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    @Transactional
    public ResultVo delete(Integer id){

        //1
        int one=roleMapper.deleteById(id);
        //2
        int two=rolePermiMapper.delete(new QueryWrapper<RolePermiDO>().eq("ROLE_ID",id));
        //3
        int three=userRoleMapper.delete(new QueryWrapper<UserRoleDO>().eq("ROLE_ID",id));

        log.info("delete rolePermi  "+two +"   records!!!" + "delete userRole "+ three +" records!!!!");
        if (one!=1){
            return ResultVoUtil.fail();
        }
        return ResultVoUtil.success();

    }

}
