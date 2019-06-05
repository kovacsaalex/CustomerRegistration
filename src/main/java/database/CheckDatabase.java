package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckDatabase {
    /*
     * Create database and table if not exists
     */

    private Connection connection = new DbConnectSql().getConnection();
    private Statement createStatement = null;

    public CheckDatabase() {
    }

    private void ChkDatabase()  {

        if (connection != null) {
            try {
                createStatement = connection.createStatement();
                System.out.println("Check createStatament! Ok!");
            } catch (SQLException ex) {
                System.out.println("Valami baj van van a createStatament létrehozásakor! / Error with createStatament!");
                System.out.println("" + ex);
            }
        }

        try {
            createStatement.executeUpdate(new Props().getCreateDbSql());
        } catch (SQLException e) {
            System.out.println("Hiba az adatbázis létrehozása közben! / Error while creating database!"+e.getMessage());
            e.printStackTrace();
        }

        try {
            createStatement.executeUpdate(new Props().getCreateTableCustomer());
            createStatement.executeUpdate(new Props().getCreateTableLoan());
            createStatement.executeUpdate(new Props().getCreateTableSavings());
            createStatement.executeUpdate(new Props().getCreateTableCustomerToLoan());
        } catch (SQLException e) {
            System.out.println("Hiba a tábla létrehozása közben! / Error while creating table!");
            e.printStackTrace();
        }

    }

    public void getCheckDatabase(){
        this.ChkDatabase();
    }
}
