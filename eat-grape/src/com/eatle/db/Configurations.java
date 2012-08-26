/**
 */
package com.eatle.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.eatle.exception.DBException;

/**
 * @Title:
 * @Description:
 * @Author:asus
 * @Since:2012-6-18
 * @Version:1.1.0
 */
public class Configurations {

     /**
      * @Description:
      * @return
     * @throws SQLException 
      */
     public static Connection getConnection(){
         try {
            return DBManager.getConnection();
        } catch (SQLException e) {
            throw new DBException(e);
        }
     }

}
