import database.CheckDatabase;
import database.DbConnectSql;
import java.time.LocalDate;
import java.time.Month;
import menu.Menu;


/**
 * @author ali
 */
public class BigPicture {

      
    public static void main(String[] args)  {

         new Menu().setVisible(true);
        // Get connenction
        new DbConnectSql().getConnection();
        // Check database and table exists, if not create
        new CheckDatabase().getCheckDatabase();
        
       
       




    }
    }