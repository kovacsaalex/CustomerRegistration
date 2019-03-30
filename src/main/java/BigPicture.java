
import menu.Menu;
import database.dataBaseSql;


/**
 * @author ali
 */
public class BigPicture {

    public static void main(String[] args)  {
       
             new Menu().setVisible(true);
        new dataBaseSql().getConnection();
       

       
    }
}
