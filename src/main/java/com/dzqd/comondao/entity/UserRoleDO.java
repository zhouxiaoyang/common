package com.dzqd.comondao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@TableName("user_role")
public class UserRoleDO {
  private int id;
  private int userId;
  private int roleId;
  private String description;
  private String creator;
  private Date createTime;
  private String updater;
  private Date updateTime;


}
