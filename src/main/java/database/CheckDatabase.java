package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CheckDatabase {
    /*
     * Create database and table if not exists
     */

    private Connection connection = new DbConnectSql().getConn();
    DatabaseMetaData dbmd = null;
    private String dbName= "admindatabase";
    private String tableName = "customer";
    private  String table1 =
            "CREATE TABLE IF NOT EXISTS "+ dbName + "." + tableName + " (\n" +
                    "  `Id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Last Name` varchar(45),\n" +
                    "  `First Name` varchar(45) NOT NULL,\n" +
                    "  `Maiden Name` varchar(45) DEFAULT NULL,\n" +
                    "  `Email` varchar(45) DEFAULT NULL,\n" +
                    "  `Birth Date` date DEFAULT NULL,\n" +
                    "  `Birth Place` varchar(45) DEFAULT NULL,\n" +
                    "  `Mother Name` varchar(45) DEFAULT NULL,\n" +
                    "  `Personal Identification Number` varchar(45) DEFAULT NULL,\n" +
                    "  `Tax Number` varchar(45) DEFAULT NULL,\n" +
                    "  `Social Security Number` varchar(45) DEFAULT NULL,\n" +
                    "  `Postal Code` varchar(45) DEFAULT NULL,\n" +
                    "  `City` varchar(45) DEFAULT NULL,\n" +
                    "  `Address` varchar(45) DEFAULT NULL,\n" +
                    "  `Moving Time` varchar(45) DEFAULT NULL,\n" +
                    "  `ID Card Number` varchar(45) DEFAULT NULL,\n" +
                    "  `Address Card Number` varchar(45) DEFAULT NULL,\n" +
                    "  `Phone Number` varchar(45) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`Id`),\n" +
                    "  UNIQUE KEY `Id_UNIQUE` (`Id`)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";
    private String table2 ="CREATE TABLE IF NOT EXISTS " + dbName + "." + tableName + "(\n" +
            "   Id serial PRIMARY KEY,\n" +
            "   Last_Name VARCHAR (50)  NOT NULL,\n" +
            "   First_Name VARCHAR (50) NOT NULL,\n" +
            "   Maiden_Name VARCHAR (50) ,\n" +
            "   Email VARCHAR (50) ,\n" +
            "   Birth_Date TIMESTAMP ,\n" +
            "   Mother_Name VARCHAR (50) ,\n" +
            "   Personal_Identification_Number VARCHAR (50) ,\n" +
            "   Tax_Number VARCHAR (50) ,\n" +
            "   XC VARCHAR (50) ,\n" +
            "   created_on TIMESTAMP ,\n" +
            "   last_login TIMESTAMP\n" +
            ");";
    private String dbpost = "SELECT 'CREATE DATABASE testdatabase' WHERE NOT EXISTS (SELECT FROM zdwrzmwyqtcqdf WHERE datname = 'testdatabase')";
    ResultSet rs = null;
    List<String> dbList = new ArrayList<>();
    List<String> tableList = new ArrayList<>();
    Statement createStatement = null;

    public CheckDatabase() {
        CheckDatabase();
    }

     public void CheckDatabase(){


        if (connection != null) {
            try {
                createStatement = connection.createStatement();
                System.out.println("Teherautó!");
            } catch (SQLException ex) {
                System.out.println("Valami baj van van a createStatament (teherautó) létrehozásakor.");
                System.out.println("" + ex);
            }
        }

        try {
             createStatement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            createStatement.executeUpdate(table1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
      //  try {
       /*     System.out.print("Check if a database exists");
            rs = connection.getMetaData().getCatalogs();


            while (rs.next()) {
                dbList.add(rs.getString(1));

            }

            if (dbList.contains(dbName)) {
                System.out.println("The database name: " + dbName + " is exists!");

            } else {*/
                System.out.println("Creating given database...");
              //  createStatement.executeUpdate("CREATE DATABASE" + dbName);
         //   createStatement.executeUpdate(table2);
            //    createStatement.executeUpdate("CREATE DATABASE" + dbName);
                System.out.println("Created given database... name: " + dbName);

       //     } catch (SQLException ex) {
        //    ex.printStackTrace();
       // }

  /*  } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("unable to create database connection");

        }*/

        // Create table if not exists
    /*    System.out.println("Check if a table exists");

        try {
            DatabaseMetaData meta = connection.getMetaData();
            ResultSet res = meta.getTables(dbName, dbName, tableName, new String[]{"TABLE"});
            while (res.next()) {

                tableList.add(res.getString("TABLE_NAME"));
                System.out.println("ok");


            }
            if (tableList.contains(tableName)) {
                System.out.println("Table " + tableName + " exists!");
            } else {
                System.out.println("Table does not exist");
                System.out.println("Creating table...");
                String sql = "CREATE TABLE IF NOT EXISTS "+ dbName + "." + tableName + " (\n"
                        + "	name varchar(20) NOT NULL,\n"
                        + "	address varchar(20) NOT NULL\n"
                        + ");";
                createStatement.executeUpdate(table1);
                System.out.println("Created table name: " + tableName +" in " + dbName + "database...");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }
}
