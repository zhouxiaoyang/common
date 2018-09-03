package com.dzqd.comondao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@TableName("menu_permi")
public class MenuPermiDO {
  private int id;
  private int menuId;
  private int permiId;
  private String menuDesc;
  private String creator;
  private Date createTime;
  private String updater;
  private Date updateTime;


}
