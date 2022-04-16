package org.swclass.mybatis.mybatisproject.jdbcProject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class SqlMapper {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private String sqlResource =
            "jdbc/sql.properties";
    private String configurationResource =
            "jdbc/config-jdbc.properties";
    private Properties sql = new Properties();
    private Properties configuration = new Properties();

    public SqlMapper() {
        try{
            configurationAsProperties();

            sqlAsProperties();

            Class.forName(configuration.getProperty("driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sqlAsProperties() throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        InputStream inputStream = contextClassLoader.getResourceAsStream(sqlResource);

        try{
            sql.load(inputStream);
        } catch (IOException e) {
            throw e;
        } finally {
            inputStream.close();
        }
    }

    private void configurationAsProperties() throws IOException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        InputStream inputStream = contextClassLoader.getResourceAsStream(configurationResource);

        try{
            configuration.load(inputStream);
        } catch (IOException e) {
            throw e;
        } finally {
            inputStream.close();
        }
    }

    protected Connection connect() throws SQLException {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(
                        configuration.getProperty("url"),
                        configuration.getProperty("username"),
                        configuration.getProperty("password"));
            }

            return connection;
        } catch (SQLException e) {
            throw e;
        }
    }

    protected String sqlById(String sqlId) {
        return sql.getProperty(sqlId);
    }
}
