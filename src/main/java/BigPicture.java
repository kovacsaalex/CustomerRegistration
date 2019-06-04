
import menu.Menu;
import database.dataBaseSql;
import database.CheckDatabase;
import database.DbConnectSql;


/**
 * @author ali
 */
public class BigPicture {


    public static void main(String[] args) {

        new Menu().setVisible(true);
        dataBaseSql dbSql = new dataBaseSql();
        //dbSql.getConnection();
        DbConnectSql conn = new DbConnectSql();
        conn.getConn();
        CheckDatabase ckdb = new CheckDatabase();




        //   new databasePostgresql();
        //new databasePostgresql();


    }
    }