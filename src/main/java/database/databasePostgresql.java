/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author alex
 */
public class databasePostgresql {
 //   DbConnectSql cn = new DbConnectSql();
 //   Props props = new Props();


/*    private Connection connection = null;
    private String user = "zdwrzmwyqtcqdf";
    private String passw = "7c9491cb61788f0f18952b658ea942254095b724f1ef53b71199e84b86d98bd5";
    private String url = "jdbc:postgresql://ec2-46-137-187-23.eu-west-1.compute.amazonaws.com:5432/deeseog3sqmv1t?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    PreparedStatement createStatement = null;
    DatabaseMetaData dbmd = null;*/
    
   // Heroku SSL (?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory)
    
    
/*    private Connection openConnection() {

        try {
            this.connection = DriverManager.getConnection(url,user,passw);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException ex) {
            System.err.println("Hiba történt az adatbáziskapcsolatban! Üzenet: " + ex.getMessage());
        }
        return this.connection;
    }*/

   /* public Connection getConnection() {
        return openConnection();
    }
    
    
    public databasePostgresql() {
        getConnection();
        getCreateStatement();

        

        
    }
    private PreparedStatement statement(){

        if (connection != null){
            try {
                Statement PreparedStatement = connection.createStatement();
                System.out.println("A teherautó ok!");
            } catch (SQLException ex) {
                System.out.println("Valami baj van van a createStatament (teherautó) létrehozásakor.");
                System.out.println(""+ex);
            }
        }
        return this.createStatement;
    }

    public PreparedStatement getCreateStatement() {
        return statement();
    }*/


}
