package com.dzqd.comondao.controller;


import com.dzqd.comondao.base.SupperMapper;
import com.dzqd.comondao.dao.MenuMapper;
import com.dzqd.comondao.entity.MenuDO;
import com.dzqd.comondao.util.ResultVoUtil;
import com.dzqd.comondao.vo.MenuTreeVO;
import com.dzqd.comondao.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description:
 * @Author: Winston Yang
 * @Date: Create in 15:55 2018/8/15
 * @Modified by:
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController<MenuDO>{
    @Autowired
    MenuMapper menuMapper;

    @Override
    protected SupperMapper<MenuDO> getMapper() {
        return menuMapper;
    }


    @PostMapping("/listAll")
    public ResultVo listAll() {
        log.info("menu list page.....");
        //查询所有菜单项
        List<MenuDO> list= menuMapper.selectList(null);
        if (list==null || list.size()==0) {
            return ResultVoUtil.success();
        }
        List<MenuTreeVO> menuTreeVO=new ArrayList<>();
        //顶级菜单父id为0
        //目前暂时只做了 两层菜单处理 后续添加层级菜单需要再处理
        for (MenuDO parent: list ) {
            MenuTreeVO menus=new MenuTreeVO();
            int parentId=parent.getParentId();
            if ( parentId==0){
                menus.setMenuName(parent.getMenuName()).setMenuUrl(parent.getMenuUrl());
                for (MenuDO children: list) {
                    if (children.getParentId()==parent.getId()){
                        menus.getChildren().add(new MenuTreeVO(children.getMenuName(),children.getMenuUrl()));
                    }
                }
                menuTreeVO.add(menus);
            }
        }

        //IPage<MenuDO> list = menuMapper.selectPage(new Page<MenuDO>(1, 10000), null);
        return ResultVoUtil.success(menuTreeVO);
    }
}
