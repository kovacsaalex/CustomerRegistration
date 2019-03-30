package regex;

import java.util.regex.Pattern;
import javax.swing.ImageIcon;

/**
 *
 * @author alexkovacs
 */
public class RegexSample {

    private final  ImageIcon iconeOk = new ImageIcon("/Users/alexkovacs/Documents/xEclipse/CustomerRegistration/src/main/java/regex/okPic.png");
    private final  ImageIcon iconeX = new ImageIcon("/Users/alexkovacs/Documents/xEclipse/CustomerRegistration/src/main/java/regex/X.png");
    public final String REGEXNAME = "([A-Za-zaáeéiíoóöőuúüűAÁEÉIÍOÓÖŐUÚÜŰ .-]+)";
    public final String REGEXEMAIL = "[\\w\\.]+@\\w+\\.[A-Za-z\\.]{2,5}";
    public final String REGEXDATE = "\\d{4}-\\d{2}-\\d{2}";
    public final String REGEXPOSTALCODE = "\\d{4}$";
    public final String REGEXPID = "\\d{1}-\\d{6}-\\d{4}$";
    public final String REGEXTAXNUMBER = "\\d{10}$";
    public final String REGEXCARD = "^\\d{6}[A-Z]{2}$";
    public final String REGEXTAJ = "^\\d{9}$";
    public final String REGEXTEL = "^(\\d{2})(\\d{7})$";
    public final String REGEXONLYNUMBER ="\\d*";
    public final String REGEXRATE = "^[\\d]{1,2}.[\\d]{0,2}$";
    public boolean VALID = true;
    private int id = 0;

    public boolean StrCheck(String Exp, String str) {
        boolean valid = Pattern.matches(Exp, str);
        if (valid) {
            id = 0;
            return true;
        }
        id++;
        System.out.println("ID*: " + id);
        return false;
    }

    public ImageIcon check(String regex, String str) {
        if (StrCheck(regex, str)) {

            return iconeOk;
        } else {

            id++;
            return iconeX;
        }
    }

    public int getId() {
        return id;
    }

    public ImageIcon getIconeOk() {
        return iconeOk;
    }

    public ImageIcon getIconeX() {
        return iconeX;
    }
    
    

}
