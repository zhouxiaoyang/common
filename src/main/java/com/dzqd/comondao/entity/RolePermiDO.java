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
@TableName("role_permi")
public class RolePermiDO {

  private int id;
  private int roleId;
  private int permiId;
  private String description;
  private String creator;
  private Date createTime;
  private String updater;
  private Date updateTime;


}
