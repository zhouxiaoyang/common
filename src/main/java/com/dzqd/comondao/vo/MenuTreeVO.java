package com.dzqd.comondao.vo;



import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 树形菜单
 * @Author: Winston Yang
 * @Date: Create in 15:07 2018/8/17
 * @Modified by:
 */
@Getter
@Setter
@Accessors(chain = true)
public class MenuTreeVO {

    private String menuName;
    private String menuUrl;
    /**
     * 子菜单
     */
    private List<MenuTreeVO> children = new ArrayList<>();

    public MenuTreeVO() {
    }

    public MenuTreeVO(String menuName,String menuUrl) {
        this.menuName=menuName;
        this.menuUrl=menuUrl;
    }
}
