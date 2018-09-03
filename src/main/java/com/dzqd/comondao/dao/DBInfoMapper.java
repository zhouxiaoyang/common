package com.dzqd.comondao.dao;


import com.dzqd.comondao.entity.DBInfoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @Author: Winston Yang
 * @Date: Create in 14:41 2018/8/6
 * @Modified by:
 */

public interface DBInfoMapper {
    /**
     *  query dbinfo by dbname
     * @param dbName
     * @return
     */
    DBInfoDO getDBInfoByDBName(String dbName);
    DBInfoDO getDBInfoByID(int id);

    /**
     *
     * @param tenantId
     * @return
     */
    DBInfoDO getDBInfoByTenantID(int tenantId);
}
