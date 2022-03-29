package org.swclass.mybatis.mybatisproject.step2;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class SqlMapper {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Properties configuration = new Properties();
    private String configurationResource = "jdbc/config-jdbc.properties";

    public SqlMapper() {
        try{
            configurationAsProperties();

            Class.forName(configuration.getProperty("driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Connection connect() throws SQLException {
        try{
            if (connection == null) {
                connection = DriverManager.getConnection(
                        configuration.getProperty("url")
                        , configuration.getProperty("username")
                        , configuration.getProperty("password")
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

    private void configurationAsProperties() throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        InputStream inputStream = contextClassLoader
                .getResourceAsStream(configurationResource);

        try{
            configuration.load(inputStream);
        } catch (IOException e) {
            throw e;
        } finally {
            inputStream.close();
        }
    }
}
