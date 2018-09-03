package com.dzqd.comondao.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dzqd.comondao.base.SupperMapper;
import com.dzqd.comondao.util.ResultVoUtil;
import com.dzqd.comondao.vo.ResultVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @Description: 基础控制类
 * @Author: Winston Yang
 * @Date: Create in 11:21 2018/8/13
 * @Modified by:
 */

public abstract class BaseController<T> {
    //this表示继承类的this
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 提供一个抽象方法 当前类的子类需要提供具体实现类的dao (mapper)
     *
     * @return 具体mapper
     */
    protected abstract SupperMapper<T> getMapper();

    /**
     * query by PK
     *
     * @param id
     * @return
     */
    @PostMapping("/findById/{id}")
    public ResultVo get(@PathVariable(value = "id") Integer id) {
        log.info("query by id ===" + id);
        return ResultVoUtil.success(getMapper().selectById(id));
    }

    /**
     * 查询并分页
     *
     * @param * @return
     */
    @PostMapping("/findAll/{page}/{size}")
    public ResultVo list(@PathVariable(value = "page") Integer page, @PathVariable("size") Integer size) {
        page = page == null ? 1 : page;
        size = size == null ? 10 : size;
        IPage<T> list = getMapper().selectPage(new Page<T>(page, size), null);
        log.info("=======" + list.getSize() + " =" + list.getRecords().size());
//        if (map!=null) {
//            IPage<T> page1 = getMapper().selectPage(new Page<T>(page, size), new QueryWrapper<T>().allEq(map));
//            log.info("22222----" + page1.getSize() + " =" + page1.getRecords().size() + " -" + list.getRecords().toString());
//        }
        return ResultVoUtil.success(list);
    }

    @PostMapping("/deleteById/{id}")
    public ResultVo delete(@PathVariable("id") Integer id) {
        log.info("delete by id ===" + id);
        int result = getMapper().deleteById(id);
        if (result == 1) {
            return ResultVoUtil.success();
        } else {
            return ResultVoUtil.fail();
        }
    }
//    @Transactional(rollbackFor = Exception.class)
//    @PostMapping("/deleteByIds")
//    public ResultVo batchDelete(@RequestBody Map<String, Object> map) {
//
//        if ( map.get("id") == null) {
//            return ResultVoUtil.other();
//        }
////        log.info("start -------"+map.get("id").toString());
//        List<Integer> idList=new ArrayList<>();
////        try {
////
////            JSONArray jsonArray=new JSONArray(map.get("id").toString());
////            for (int i = 0; i <jsonArray.length() ; i++) {
////                idList.add(Integer.parseInt(jsonArray.get(i).toString()));
////
////            }
////            log.info("idlist====="+idList.toString());
////        }catch (JSONException e){
////            e.printStackTrace();
////        }
//        idList.add(1);idList.add(5);
//        int result=getMapper().deleteBatchIds(idList);
//        if (result == idList.size()) {
//            return ResultVoUtil.success();
//
//        }else {
//            return ResultVoUtil.fail();
//        }
//       // return ResultVoUtil.success();
//    }

    @PostMapping("/save")
    public ResultVo save(@RequestBody T t) {

        int result = getMapper().insert(t);
        if (result == 1) {
            return ResultVoUtil.success();
        } else {
            return ResultVoUtil.fail();
        }
    }

    @PostMapping("/updateById")
    public ResultVo update(@RequestBody T t) {
        int result = getMapper().updateById(t);
        if (result == 1) {
            return ResultVoUtil.success();
        } else {
            return ResultVoUtil.fail();
        }
    }
}
