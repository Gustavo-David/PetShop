package com.petshop.sql;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    public static Connection conn = null;

    public Connection getConnection() {

        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException("GetConnection erros: " + e.getMessage());
            }
            return conn;
        }

        return conn;
    }

    private static Properties loadProperties() {
        try (FileInputStream arquivo = new FileInputStream("src\\main\\resources\\db.properties")) {
            Properties props = new Properties();
            props.load(arquivo);
            return props;
        } catch (IOException e) {
            throw new DbException("Open file errors: " + e.getMessage());
        }

    }

    public static void CloseConnection() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;

            } catch (SQLException e) {
                throw new DbException("Close connection Erros: " + e.getMessage());
            }
        }
    }
}
