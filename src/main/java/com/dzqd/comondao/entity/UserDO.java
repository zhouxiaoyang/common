package com.dzqd.comondao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Description:
 * @Author: Winston Yang
 * @Date: Create in 14:41 2018/8/6
 * @Modified by:
 */
@Setter
@Getter
@ToString
@TableName("user")
public class UserDO {
    /**
     * PK
     */
    @TableId("user_id")
    private int id;
    /**
     * 用户名
     */
    private String userName;
//    /**
//     * 用户编码uuid
//     */
//    private String userCode;
    /**
     * 用户所属租户id
     */
    private String tenementId;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮件
     */
    private String email;
//    /**
//     * 用户类型
//     */
//    private int userType;
    /**
     * 用户描述
     */
    private String userDesc;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新者
     */
    private String updater;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 状态
     */
    private int status;
    public UserDO(){}


}
