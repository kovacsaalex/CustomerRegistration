package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class Props {

    private Properties props = new Properties();
    // private String configSql = "/Users/alex/Documents/Dev_Projects/CustomerRegistration/configSql.ini";
    // private String configMacMini = "/Users/alexkovacs/Documents/Dev_Projects/CustomerRegistration/configSql.ini";
    // private String configPostgreSql = "/Users/alex/Documents/Dev_Projects/CustomerRegistration/src/main/resources/configPostgreSql.ini";
    



    private String username = "";
    private String password = "";
     private String url = "";

    //SQL Query for creating database
    private  String createDbSql = "";

    //SQL Query for creating table
    private  String createTableCustomer = "";
    private  String createTableLoan = "";
    private  String createTableSavings = "";
    private  String createTableCustomerToLoan = "";

    // SQL Client
    private String insertClient = "";
    private String insertClientToLoan = "";
    private String findAllClients = "";
    private String findbyIdClients = "";
    private String searchFromClients = "";
    private String clientUpdate = "";
    private String clientDelete = "";
    //SQL Loan
    private String insertCToL = "";
    private String insertLoan = "";
    private String loanUpdate = "";
    private String findAllLoans = "";
    private String findByIdLoan = "";
    private String searchFromLoan = "";
    private String loanDelete = "";
    //SQL Savings
    private String insertLtp = "";
    private String ltpUpdate = "";
    private String findAllLtp = "";
    private String findbyIdLtp = "";
    private String searchFromLtp = "";
    private String LtpDelete = "";
    // SQL ALL search
    private String allKindList ="";
    private String searhFromAllKindLists ="";
    private String clientLoanList ="";


    Props() {
        getProps();
                   }

    public String getFindAllLtp() {
        return findAllLtp;
    }

    private Properties getProps(){
        File file;

        try {



             //FileInputStream fis = new FileInputStream("/Users/alexkovacs/Documents/Dev_Projects/CustomerRegistration/src/main/java/database/configSql.ini");
             //props.load(fis);
            props.load(Props.class.getResourceAsStream("/configPostgreSql.ini"));
            //props.load(Props.class.getResourceAsStream("/configSql.ini"));
            
            
            username = props.getProperty("usr");
            password = props.getProperty("passw");
            url = props.getProperty("url");
            createDbSql = props.getProperty("createDbSql") + " " + props.getProperty("dbName") + ";";
             createTableCustomer = props.getProperty("createTableSql") + " " + props.getProperty("dbName") + props.getProperty("tableName") + props.getProperty("createTableCustomer");
            //createTableCustomer = props.getProperty("createTableSql") + " " + props.getProperty("tableName") +" "+ props.getProperty("createTableCustomer");

            createTableLoan = props.getProperty("createTableSql") + " " + props.getProperty("dbName") + props.getProperty("tableNameLoan") + props.getProperty("createTableLoan");
            createTableSavings = props.getProperty("createTableSql") + " " + props.getProperty("dbName") + props.getProperty("tableNameSavings") + props.getProperty("createTableSavings");
            createTableCustomerToLoan = props.getProperty("createTableSql") + " " + props.getProperty("dbName") + props.getProperty("tableNameCustomerToLoan") + props.getProperty("createTableCustomerToLoan");
            // Client
            insertClient = props.getProperty("insertClient");
            insertClientToLoan = props.getProperty("insertClientToLoan");
            insertCToL = props.getProperty("insertCToL");
            findAllClients = props.getProperty("findAllClients");
            findbyIdClients = props.getProperty("findbyIdClients");
            searchFromClients = props.getProperty("searchFromClients");
            clientUpdate = props.getProperty("clientUpdate");
            clientDelete = props.getProperty("clientDelete");
            //Loan
            insertLoan = props.getProperty("insertLoan");
            loanUpdate = props.getProperty("loanUpdate");
            findAllLoans = props.getProperty("findAllLoans");
            findByIdLoan = props.getProperty("findByIdLoan");
            searchFromLoan = props.getProperty("searchFromLoan");
            loanDelete = props.getProperty("loanDelete");
            //Savings
            insertLtp = props.getProperty("insertLtp");
            ltpUpdate = props.getProperty("ltpUpdate");
            findAllLtp = props.getProperty("findAllLtp");
            findbyIdLtp = props.getProperty("findbyIdLtp");
            searchFromLtp = props.getProperty("searchFromLtp");
            LtpDelete = props.getProperty("LtpDelete");
            // AllList
            allKindList = props.getProperty("allKindList");
            searhFromAllKindLists = props.getProperty("searhFromAllKindLists");
            clientLoanList = props.getProperty("clientLoanList");


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
        return createTableCustomer;
    }

    public String getCreateTableLoan() {
        return createTableLoan;
    }

    public String getCreateTableSavings() {
        return createTableSavings;
    }

    public String getCreateTableCustomerToLoan() {
        return createTableCustomerToLoan;
    }

    public String getCreateDbSql() {
        return createDbSql;
    }

    public String getInsertClient() {
        return insertClient;
    }

    public String getInsertClientToLoan() {
        return insertClientToLoan;
    }

    public String getFindAllClients() {
        return findAllClients;
    }

    public String getFindbyIdClients() {
        return findbyIdClients;
    }

    public String getSearchFromClients() {
        return searchFromClients;
    }

    public String getClientUpdate() {
        return clientUpdate;
    }

    public String getClientDelete() {
        return clientDelete;
    }

    public String getInsertCToL() {
        return insertCToL;
    }

    public String getInsertLoan() {
        return insertLoan;
    }

    public String getLoanUpdate() {
        return loanUpdate;
    }

    public String getFindAllLoans() {
        return findAllLoans;
    }

    public String getFindByIdLoan() {
        return findByIdLoan;
    }

    public String getSearchFromLoan() {
        return searchFromLoan;
    }

    public String getLoanDelete() {
        return loanDelete;
    }

    public String getInsertLtp() {
        return insertLtp;
    }

    public String getLtpUpdate() {
        return ltpUpdate;
    }

    public String getFindbyIdLtp() {
        return findbyIdLtp;
    }

    public String getSearchFromLtp() {
        return searchFromLtp;
    }

    public String getLtpDelete() {
        return LtpDelete;
    }

    public String getAllKindList() {
        return allKindList;
    }

    public String getSearhFromAllKindLists() {
        return searhFromAllKindLists;
    }

    public String getClientLoanList() {
        return clientLoanList;
    }
}
