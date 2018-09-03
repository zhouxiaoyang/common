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
@TableName("menu")
public class MenuDO {
  @TableId("menu_id")
  private int id;
  private String menuName;
  private String menuCode;
  private String menuUrl;
  private int parentId;
  private String menuDesc;
  private String creator;
  private Date createTime;
  private String updater;
  private Date updateTime;


}
