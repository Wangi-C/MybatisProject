package org.swclass.mybatis.mybatisproject.jdbcProject;

import java.sql.*;
import java.util.List;

public class Application {
    public Shop view(List<Object> parameters) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Shop shop = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE"
                    , "mybatis"
                    , "mybatis$");

            preparedStatement =
                    conn.prepareStatement("SELECT SHOP_NO, SHOP_NAME, SHOP_LOCATION, SHOP_STATUS " +
                    "FROM SHOP " +
                    "WHERE SHOP_NO = ? AND SHOP_STATUS = ?");

            preparedStatement.setInt(1, (Integer) parameters.get(0));
            preparedStatement.setString(2, String.valueOf(parameters.get(1)));

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                shop = new Shop();

                shop.setShopNo(resultSet.getInt("SHOP_NO"));
                shop.setShopName(resultSet.getString("SHOP_NAME"));
                shop.setShopLoc(resultSet.getString("SHOP_LOCATION"));
                shop.setShopStatus(resultSet.getString("SHOP_STATUS"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
        return shop;
    }
}
