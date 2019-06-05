package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectSql implements AutoCloseable {
    private Connection conn = null;
    private Props props = new Props();



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

    public Connection getConnection() {
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
