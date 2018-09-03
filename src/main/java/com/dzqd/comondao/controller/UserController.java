package com.dzqd.comondao.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dzqd.comondao.base.SupperMapper;
import com.dzqd.comondao.dao.UserMapper;
import com.dzqd.comondao.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Winston Yang
 * @Date: Create in 11:02 2018/8/10
 * @Modified by:
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserDO>{
    @Autowired
    UserMapper userMapper;

    @Override
    protected SupperMapper<UserDO> getMapper() {
        return userMapper;
    }

    /**
     * 通过用户名和密码登录
     * @return
     */
    @PostMapping("/login")
    public UserDO login(String userName,String password){
        return userMapper.selectOne(
                new QueryWrapper<UserDO>().eq("LOGIN_NAME",userName).eq("PASSWORD",password));
    }

//    @GetMapping("/get/{id}")
//    public ResultVo get(@PathVariable("id") Integer id){
//        UserDO userDo=userMapper.selectById(id);
//        log.info("userDO = "+userDo.toString());
//        return ResultVoUtil.success(userDo);
//    }


}
