package org.swclass.mybatis.mybatisproject.step1;

import java.sql.*;

public class SqlMapper {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public SqlMapper() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Connection connect() throws SQLException {
        try{
            if (connection == null) {
                connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:XE"
                        , "mybatis"
                        , "mybatis$"
                );
            }
            return connection;
        } catch (SQLException e) {
            throw e;
        }
    }

    protected void release() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
