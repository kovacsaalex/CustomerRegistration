package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import database.Props;

public class DbConnectSql implements AutoCloseable {
    private Connection conn = null;
    Props props = new Props();



private Connection DbConnect(){

    try {
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(props.getUrl(), props.getUsername(), props.getPassword());
        System.out.println("Connected database successfully...");

    } catch (SQLException ex) {
        System.out.println("Valami baj van a connection (híd) létrehozásakor.");
        System.out.println("" + ex);
    }
    return conn;
}

    public Connection getConn() {
        return DbConnect();
    }

    @Override
    public void close()  {

        try {
            if (conn != null){
                this.conn.close();
                System.out.println("Connection close");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
