package com.dzqd.comondao.util;


import com.dzqd.comondao.enums.ResultEnum;
import com.dzqd.comondao.vo.ResultVo;

/**
 * @Description: 结果集util
 * @Author: Winston Yang
 * @Date: Create in 10:18 2018/4/26
 * @Modified by:
 */
public class ResultVoUtil {

    public static ResultVo success(int code, String msg, Object o) {
        ResultVo resultVo = new ResultVo().setCode(code).setMsg(msg).setData(o);

        return resultVo;
    }

    public static ResultVo success() {
        return success(null);
    }

    /**
     * 成功
     */
    public static ResultVo success(Object data) {

        return success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    public static ResultVo fail(String msg) {
        ResultVo resultVo = new ResultVo().setMsg(msg).setCode(ResultEnum.FAIL.getCode());

        return resultVo;
    }

    public static ResultVo fail() {
        ResultVo resultVo = new ResultVo().setMsg(ResultEnum.FAIL.getMsg()).setCode(ResultEnum.FAIL.getCode());

        return resultVo;
    }

    public static ResultVo other() {
        ResultVo resultVo = new ResultVo().setMsg(ResultEnum.OTHER.getMsg()).setCode(ResultEnum.OTHER.getCode());

        return resultVo;
    }
}
