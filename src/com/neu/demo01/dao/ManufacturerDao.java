/**
 * 
 */
package com.neu.demo01.dao;

import com.neu.demo01.entity.Manufacturer;

import java.sql.SQLException;

/**
 * @author Administrator
 *
 */
public interface ManufacturerDao {
    int save(Manufacturer man) throws SQLException;
}
