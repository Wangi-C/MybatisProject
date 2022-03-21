package org.swclass.mybatis.mybatisproject.jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcProject {
    static {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE","mybatis", "mybatis$");
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM SHOP");
            while (rs.next()) {
                int shopNo = rs.getInt("SHOP_NO");
                System.out.println("shopNo = " + shopNo);

                String shopName = rs.getString("SHOP_NAME");
                System.out.println("shopName = " + shopName);

                String shopLoc = rs.getString("SHOP_LOCATION");
                System.out.println("shopLoc = " + shopLoc);

                String shopStatus = rs.getString("SHOP_STATUS");
                System.out.println("shopStatus = " + shopStatus);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try{
                rs.close();
                stmt.close();
                connection.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
