package org.swclass.mybatis.mybatisproject.step0;

import org.swclass.mybatis.mybatisproject.jdbcProject.SqlMapper;

import java.sql.*;
import java.util.List;

public class Application extends SqlMapper {
    public Shop view(List<Object> parameters) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Shop shop = null;

        try {
            String sql = sqlById("select");

            preparedStatement = connect().prepareStatement(sql);

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
        }
        return shop;
    }
}
