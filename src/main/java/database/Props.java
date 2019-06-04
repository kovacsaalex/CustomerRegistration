package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Props {

    Properties props = new Properties();
    private String configSql = "/Users/alex/Documents/Dev_Projects/CustomerRegistration/configSql.ini";
    private String configPostgreSql = "/Users/alex/Documents/Dev_Projects/CustomerRegistration/configPostgreSql.ini";
    private  String username = "";
    private  String password = "";
    private  String url = "jdbc:mysql://localhost:3306/database?useLegacyDatetimeCode=false&serverTimezone=Europe/Budapest";

    public Props() {
        getProps();
    }

    private Properties getProps(){
        File file;
        try {
            FileInputStream fis = new FileInputStream(configSql);
            props.load(fis);
            username = props.getProperty("usr");
            password = props.getProperty("passw");
            url = props.getProperty("url");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
