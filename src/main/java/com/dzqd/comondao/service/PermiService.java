package com.dzqd.comondao.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dzqd.comondao.dao.MenuPermiMapper;
import com.dzqd.comondao.dao.PermiMapper;
import com.dzqd.comondao.dao.RolePermiMapper;
import com.dzqd.comondao.entity.MenuPermiDO;
import com.dzqd.comondao.entity.RolePermiDO;
import com.dzqd.comondao.util.ResultVoUtil;
import com.dzqd.comondao.vo.ResultVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: Winston Yang
 * @Date: Create in 17:25 2018/8/20
 * @Modified by:
 */
@Service
@Log
public class PermiService {

    @Autowired
    PermiMapper permiMapper;

    @Autowired
    MenuPermiMapper menuPermiMapper;

    @Autowired
    RolePermiMapper rolePermiMapper;

    @Transactional
    public ResultVo delete(Integer id){
        //1
        int one=permiMapper.deleteById(id);
        //2
        int two=menuPermiMapper.delete(new QueryWrapper<MenuPermiDO>().eq("PERMI_ID",id));
        //3
        int three=rolePermiMapper.delete(new QueryWrapper<RolePermiDO>().eq("PERMI_ID",id));

        log.info("delete menuPermi  "+two +" records and delete rolePermi "+ three +" records");

        if (one!=1){
            return ResultVoUtil.fail();
        }
        return ResultVoUtil.success();
    }

}
