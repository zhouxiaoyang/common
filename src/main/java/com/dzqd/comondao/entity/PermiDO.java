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
@TableName("permi")
public class PermiDO {
  @TableId("permi_id")
  private int id;
  private String permission;
  private String permiDesc;
  private String creator;
  private Date createTime;
  private String updater;
  private Date updateTime;


}
