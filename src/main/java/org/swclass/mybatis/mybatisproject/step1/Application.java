package org.swclass.mybatis.mybatisproject.step1;

import java.sql.*;
import java.util.List;

public class Application extends SqlMapper {
    public Shop view(List<Object> parameters) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Shop shop = null;

        try {
            preparedStatement =
                    connect().prepareStatement("SELECT SHOP_NO, SHOP_NAME, SHOP_LOCATION, SHOP_STATUS " +
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
        } catch (SQLException e) {
            throw e;
        } finally {
            release();
        }

        return shop;
    }
}
