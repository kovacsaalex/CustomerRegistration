package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class Props {

    private Properties props = new Properties();
    private String configSql = "/Users/alex/Documents/Dev_Projects/CustomerRegistration/configSql.ini";
    private String configPostgreSql = "/Users/alex/Documents/Dev_Projects/CustomerRegistration/configPostgreSql.ini";
    private String username = "";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/database?useLegacyDatetimeCode=false&serverTimezone=Europe/Budapest";

    //SQL Query for creating database
    private  String createDbSql = "";

    //SQL Query for creating table
    private  String createTableCustomerSql = "";



    Props() {
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
            createDbSql = props.getProperty("createDbSql")+" "+props.getProperty("dbName");
            createTableCustomerSql = props.getProperty("createTableSql")+" "+props.getProperty("dbName")+props.getProperty("tableName")+props.getProperty("createTableCustomer2");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    String getUrl() {
        return url;
    }

    String getCreateTableCustomer() {
        return createTableCustomerSql;
    }

    String getCreateDbSql() {
        return createDbSql;
    }
}
