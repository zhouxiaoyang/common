package com.dzqd.comondao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@TableName("role")
public class RoleDO {
  @TableId("role_id")
  private int id;
  private String roleCode;
  private String roleName;
  private String creator;
  private Date createTime;
  private String updater;
  private Date updateTime;


}
