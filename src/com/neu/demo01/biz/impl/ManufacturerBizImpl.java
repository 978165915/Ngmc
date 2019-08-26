package com.neu.demo01.biz.impl;

import com.neu.demo01.biz.ManufacturerBiz;
import com.neu.demo01.dao.impl.ManufacturerDaoImpl;
import com.neu.demo01.entity.Manufacturer;

import java.sql.SQLException;

public class ManufacturerBizImpl implements ManufacturerBiz {




    @Override
    public int save(Manufacturer manufacturer) {
        try {
            return new ManufacturerDaoImpl().save(manufacturer);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}


