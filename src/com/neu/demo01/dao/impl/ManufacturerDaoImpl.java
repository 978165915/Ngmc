package com.neu.demo01.dao.impl;

import com.neu.demo01.dao.ManufacturerDao;
import com.neu.demo01.entity.Manufacturer;
import com.neu.demo01.util.DBUtil;

import java.sql.SQLException;

public  class ManufacturerDaoImpl extends DBUtil implements ManufacturerDao {



    @Override
    public int save(Manufacturer manufacturer) throws SQLException {
        String sql="insert into NGMC_manufacturer(name_en, name_cn, gmc_report_type, gmc_report_url, description, sts_cd) " +
                "values (?, ?, ?, ?, ?, ?)";
        return executeUpdate(sql,manufacturer.getName_en(),manufacturer.getName_cn(),
                manufacturer.getGmc_report_type(),manufacturer.getGmc_report_url(),manufacturer.getDescription(),
                manufacturer.getSts_cd());
    }
}
