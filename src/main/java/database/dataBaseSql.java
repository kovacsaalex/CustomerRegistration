package database;



import repository.*;
import client.Client;
import loan.Loan;
import ltp.Ltp;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lists.AllKindList;

/**
 * This class make SQL Query with MySql database
 */
public class dataBaseSql implements ReposDataBase {

    DbConnectSql cn = new DbConnectSql();
    int id = 0;

    public dataBaseSql() {
    }


    public Connection getConnection() {
        return cn.getConn();
    }

    /**
     * id változások visszajelzése (Ha a rögzités sikeres) / if add a new client successfully get an Id
     * @return 
     */
    
    @Override
    public int sqlIdCount() {
        return id;
    }

    // Client ******************
    
    /**
     * Insert new client to the MySQL database with personal data
     * @param adat 
     */
    @Override
    public void insertClient(Client adat) {

        try (PreparedStatement insertNewClient = this.getConnection().prepareStatement("INSERT INTO customer (`Last Name`, `First Name`, `Maiden Name`, `Email`, `Birth Place`, `Mother Name`,"
                + " `Personal Identification Number`, `Tax Number`, `Social Security Number`, `Postal Code`, `City`,"
                + " `Address`, `Moving Time`, `ID Card Number`, `Address Card Number`, `Phone Number`,`Birth Date`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS)) {

            insertNewClient.setString(1, adat.getVezetekNev());
            insertNewClient.setString(2, adat.getKeresztNevek());
            insertNewClient.setString(3, adat.getLeanyKoriNev());
            insertNewClient.setString(4, adat.getEmail());
            insertNewClient.setString(5, adat.getSzulHely());
            insertNewClient.setString(6, adat.getAnyuNeve());
            insertNewClient.setString(7, adat.getSzemelyiSzam());
            insertNewClient.setString(8, adat.getAdoAzonosito());
            insertNewClient.setString(9, adat.getTajSzam());
            insertNewClient.setInt(10, adat.getIranyitoSzam());
            insertNewClient.setString(11, adat.getVaros());
            insertNewClient.setString(12, adat.getLakCim());
            insertNewClient.setString(13, adat.getLakhelyido());
            insertNewClient.setString(14, adat.getSzIgSzam());
            insertNewClient.setString(15, adat.getLakCimSzam());
            insertNewClient.setString(16, adat.getTelSzam());
            insertNewClient.setDate(17, Date.valueOf(adat.getSzulIdo()));

            insertNewClient.executeUpdate();
            ResultSet generatedKeys = insertNewClient.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {

        }
    }

    /**
     * loan data link with the clients
     * @param adat
     * @throws SQLException 
     */
    @Override
    public void insertClientToLoan(Client adat) throws SQLException {
        try (PreparedStatement insertNewClient = this.getConnection().prepareStatement("INSERT INTO customer (`Last Name`, `First Name`, `Maiden Name`, `Email`, `Birth Place`, `Mother Name`,"
                + " `Personal Identification Number`, `Tax Number`, `Social Security Number`, `Postal Code`, `City`,"
                + " `Address`, `Moving Time`, `ID Card Number`, `Address Card Number`, `Phone Number`,`Birth Date`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS)) {

            insertNewClient.setString(1, adat.getVezetekNev());
            insertNewClient.setString(2, adat.getKeresztNevek());
            insertNewClient.setString(3, adat.getLeanyKoriNev());
            insertNewClient.setString(4, adat.getEmail());
            insertNewClient.setString(5, adat.getSzulHely());
            insertNewClient.setString(6, adat.getAnyuNeve());
            insertNewClient.setString(7, adat.getSzemelyiSzam());
            insertNewClient.setString(8, adat.getAdoAzonosito());
            insertNewClient.setString(9, adat.getTajSzam());
            insertNewClient.setInt(10, adat.getIranyitoSzam());
            insertNewClient.setString(11, adat.getVaros());
            insertNewClient.setString(12, adat.getLakCim());
            insertNewClient.setString(13, adat.getLakhelyido());
            insertNewClient.setString(14, adat.getSzIgSzam());
            insertNewClient.setString(15, adat.getLakCimSzam());
            insertNewClient.setString(16, adat.getTelSzam());
            insertNewClient.setDate(17, Date.valueOf(adat.getSzulIdo()));
            insertNewClient.executeUpdate();
            ResultSet generatedKeys = insertNewClient.getGeneratedKeys();
            if (generatedKeys.next()) {
                System.out.println("hív");
                id = generatedKeys.getInt(1);
                PreparedStatement insertCToL = this.getConnection().prepareStatement("INSERT INTO `Customer_to_Loan` (`Id customer`, `Id loan`) VALUES (?,?)");
                insertCToL.setInt(1, id);
                insertCToL.setInt(2, adat.getId());
                insertCToL.executeUpdate();
            }
        } catch (SQLException ex) {

        }
    }

    /**
     * List all clients from the database
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Client> findAllClients() throws SQLException {
        // ResultSet all = this.getConnection().prepareStatement("SELECT * from customer").executeQuery();
        ResultSet all = this.getConnection().prepareStatement("SELECT * from customer").executeQuery();
        List<Client> ret = makeList(all);
        return ret;
    }

    /**
     * Find client in the database by ID
     * @param id
     * @return
     * @throws SQLException 
     */
    @Override
    public Client findbyIdClients(int id) throws SQLException {

        PreparedStatement fIdClient = this.getConnection().prepareStatement("SELECT * FROM customer WHERE id=?;");
        fIdClient.setInt(1, id);
        ResultSet findById = fIdClient.executeQuery();
        List<Client> ret = makeList(findById);
        for (Client value : ret) {
            if (value.getId() == id) {

                return value;
            }
        }
        return null;
    }

    /**
     * If you list all clients from the database, you can search in this list
     * @param ValToSearch
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Client> searchFromClients(String ValToSearch) throws SQLException {
        ResultSet searchClient = this.getConnection().
                prepareStatement("SELECT * from customer "
                        + "WHERE CONCAT( `customer`.`Id`,\n"
                        + "    `customer`.`Last Name`,\n"
                        + "    `customer`.`First Name`,\n"
                        + "    `customer`.`Maiden Name`,\n"
                        + "    `customer`.`Email`,\n"
                        + "    `customer`.`Birth Date`,\n"
                        + "    `customer`.`Birth Place`,\n"
                        + "    `customer`.`Mother Name`,\n"
                        + "    `customer`.`Personal Identification Number`,\n"
                        + "    `customer`.`Tax Number`,\n"
                        + "    `customer`.`Social Security Number`,\n"
                        + "    `customer`.`Postal Code`,\n"
                        + "    `customer`.`City`,\n"
                        + "    `customer`.`Address`,\n"
                        + "    `customer`.`Moving Time`,\n"
                        + "    `customer`.`ID Card Number`,\n"
                        + "    `customer`.`Address Card Number`,\n"
                        + "    `customer`.`Phone Number`) LIKE '%" + ValToSearch + "%'").executeQuery();
        List<Client> ret = makeList(searchClient);
        return ret;
    }
    
/**
 * Modify client 
 * @param client 
 */
    @Override
    public void update(Client client) {

        try {

            PreparedStatement clientUpdate = this.getConnection().prepareStatement("UPDATE customer SET `Last Name`=?, `First Name`=?,"
                    + "`Maiden Name`=?, `Email`=?, `Birth Place`=?, `Mother Name`=?, `Personal Identification Number`=?, "
                    + "`Tax Number`=?, `Social Security Number`=?, `Postal Code`=?, `City`=?,`Address`=?, `Moving Time`=?, `ID Card Number`=?, "
                    + "`Address Card Number`=?, `Phone Number`=?,`Birth Date`=? WHERE Id=?");

            clientUpdate.setString(1, client.getVezetekNev());
            clientUpdate.setString(2, client.getKeresztNevek());
            clientUpdate.setString(3, client.getLeanyKoriNev());
            clientUpdate.setString(4, client.getEmail());
            clientUpdate.setString(5, client.getSzulHely());
            clientUpdate.setString(6, client.getAnyuNeve());
            clientUpdate.setString(7, client.getSzemelyiSzam());
            clientUpdate.setString(8, client.getAdoAzonosito());
            clientUpdate.setString(9, client.getTajSzam());
            clientUpdate.setInt(10, client.getIranyitoSzam());
            clientUpdate.setString(11, client.getVaros());
            clientUpdate.setString(12, client.getLakCim());
            clientUpdate.setString(13, client.getLakhelyido());
            clientUpdate.setString(14, client.getSzIgSzam());
            clientUpdate.setString(15, client.getLakCimSzam());
            clientUpdate.setString(16, client.getTelSzam());
            clientUpdate.setDate(17, Date.valueOf(client.getSzulIdo()));
            clientUpdate.setInt(18, client.getId());

            clientUpdate.executeUpdate();

        } catch (SQLException e) {
            System.out.println("e:" + e.getMessage());
        }
    }

    private List<Client> makeList(ResultSet rs) throws SQLException {
        List<Client> ret = new ArrayList<>();
        while (rs.next()) {
            ret.add(makeOne(rs));
        }
        return ret;
    }

    private Client makeOne(ResultSet rs) throws SQLException {
        Client sz = new Client();
        sz.setId(rs.getInt("id"));
        sz.setVezetekNev(rs.getString("Last Name"));
        sz.setKeresztNevek(rs.getString("First Name"));
        sz.setLeanyKoriNev(rs.getString("Maiden Name"));
        sz.setEmail(rs.getString("Email"));
        sz.setSzulHely(rs.getString("Birth Place"));
        sz.setAnyuNeve(rs.getString("Mother Name"));
        sz.setSzemelyiSzam(rs.getString("Personal Identification Number"));
        sz.setAdoAzonosito(rs.getString("Tax Number"));
        sz.setTajSzam(rs.getString("Social Security Number"));
        sz.setIranyitoSzam(rs.getInt("Postal Code"));
        sz.setVaros(rs.getString("City"));
        sz.setLakCim(rs.getString("Address"));
        sz.setLakhelyido(rs.getString("Moving Time"));
        sz.setSzIgSzam(rs.getString("ID Card Number"));
        sz.setLakCim(rs.getString("Address Card Number"));
        sz.setTelSzam(rs.getString("Phone Number"));
        sz.setSzulIdo(rs.getDate("Birth date").toLocalDate());
        return sz;

    }

    /**
     * Delete client from the database (Can't undo!!)
     * @param id
     * @throws SQLException 
     */
    @Override
    public void ClientDelete(int id) throws SQLException {
        PreparedStatement deleteClientById = this.getConnection().prepareStatement("delete from customer where `Id` =?");
        deleteClientById.setInt(1, id);
        deleteClientById.executeUpdate();
    }

    // Loan ******************
    /**
     * Insert new Loan to the MySQL database with data
     * @param adat 
     */
    @Override
    public void insertLoan(Loan adat) {
        try {
            PreparedStatement insertNewLoan = this.getConnection().prepareStatement("INSERT INTO loan (`Type`, `Amount`,`Start`,`End`,`Term`,`Interest Rate`,`Hrsz`,`City`,"
                    + "`Postal Code`,`Address`,`Size`,`Value`,`Condition`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

            insertNewLoan.setString(1, adat.getHitelTipus());
            insertNewLoan.setInt(2, adat.getOsszeg());
            insertNewLoan.setDate(3, Date.valueOf(adat.getKezdet()));
            insertNewLoan.setDate(4, Date.valueOf(adat.getLejarat()));
            insertNewLoan.setInt(5, adat.getFutamido());
            insertNewLoan.setDouble(6, adat.getKamatlab());
            insertNewLoan.setString(7, adat.getHrsz());
            insertNewLoan.setString(8, adat.getfVaros());
            insertNewLoan.setInt(9, adat.getfIrSzam());
            insertNewLoan.setString(10, adat.getfCim());
            insertNewLoan.setInt(11, adat.getMeret());
            insertNewLoan.setInt(12, adat.getBecsErtek());
            insertNewLoan.setString(13, adat.getAllapot());
            insertNewLoan.executeUpdate();

            ResultSet generatedKeys = insertNewLoan.getGeneratedKeys();

            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);

                PreparedStatement insertCToL = this.getConnection().prepareStatement("INSERT INTO `Customer_to_Loan` (`Id customer`, `Id loan`) VALUES (?,?)");
                insertCToL.setInt(1, adat.getUgyfelId());

                insertCToL.setInt(2, id);

                insertCToL.executeUpdate();

            }

            insertNewLoan.close();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage() + e.getSQLState());
        }
    }

    /**
     * Modify loan data
     * @param loan 
     */
    @Override
    public void update(Loan loan) {
        try {
            PreparedStatement loanupdate = this.getConnection().prepareStatement("UPDATE loan SET `Type`=?, `Amount`=?, `Start`=?, `End`=?,`Term`=?,  `Interest Rate`=?,`Hrsz`=?, `City`=?, `Postal Code`=?, `Address`=?,`Size`=?,`Value`=?,`Condition`=? WHERE `Id Loan`=?");
            loanupdate.setString(1, loan.getHitelTipus());
            loanupdate.setInt(2, loan.getOsszeg());
            loanupdate.setDate(3, Date.valueOf(loan.getKezdet()));
            loanupdate.setDate(4, Date.valueOf(loan.getLejarat()));
            loanupdate.setInt(5, loan.getFutamido());
            loanupdate.setDouble(6, loan.getKamatlab());
            loanupdate.setString(7, loan.getHrsz());
            loanupdate.setString(8, loan.getfVaros());
            loanupdate.setInt(9, loan.getfIrSzam());
            loanupdate.setString(10, loan.getfCim());
            loanupdate.setInt(11, loan.getMeret());
            loanupdate.setInt(12, loan.getBecsErtek());
            loanupdate.setString(13, loan.getAllapot());
            loanupdate.setInt(14, loan.getUgyfelId());
            loanupdate.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ltpUpdate:" + e.getMessage());
        }
    }
   
    /**
     * List all loans
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Loan> findAllLoans() throws SQLException {
        ResultSet all = this.getConnection().prepareStatement("SELECT * from loan").executeQuery();
        List<Loan> retltp = makeLoanList(all);
        return retltp;
    }

    /**
     * find loan by Id
     * @param id
     * @return
     * @throws SQLException 
     */
    @Override
    public Loan findByIdLoan(int id) throws SQLException {
        PreparedStatement fIdLoan = this.getConnection().prepareStatement("SELECT * from loan WHERE `Id Loan`=?;");
        fIdLoan.setInt(1, id);
        ResultSet findbyIdLoan = fIdLoan.executeQuery();
        List<Loan> retloan = makeLoanList(findbyIdLoan);
        for (Loan loan : retloan) {
            if (loan.getUgyfelId() == id) {
                return loan;
            }
        }
        return null;
    }

    /**
     * If you list all loans you can search inside
     * @param ValToSearch
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Loan> searchFromLoan(String ValToSearch) throws SQLException {

        ResultSet searchloan = this.getConnection().prepareStatement("SELECT * from loan WHERE CONCAT(`Id Loan`,`Type`,`Amount`,`Start`,`End`,`Term`,`Interest Rate`,`Hrsz`,`City`,`Postal Code`,`Address`,`Size`,`Value`,`Condition`) LIKE '%" + ValToSearch + "%'").executeQuery();

        List<Loan> retloan = makeLoanList(searchloan);
        return retloan;

    }

    private List<Loan> makeLoanList(ResultSet rs) throws SQLException {
        List<Loan> ret = new ArrayList<>();
        while (rs.next()) {
            ret.add(makeLoanOne(rs));
        }
        return ret;
    }

    private Loan makeLoanOne(ResultSet rs) throws SQLException {
        Loan sz = new Loan();
        sz.setUgyfelId(rs.getInt("Id Loan"));
        sz.setHitelTipus(rs.getString("Type"));
        sz.setOsszeg(rs.getInt("Amount"));
        sz.setKezdet(LocalDate.parse(rs.getString("Start")));
        sz.setLejarat(LocalDate.parse(rs.getString("End")));
        sz.setFutamido(rs.getInt("Term"));
        sz.setKamatlab(rs.getDouble("Interest Rate"));
        sz.setHrsz(rs.getString("Hrsz"));
        sz.setfVaros(rs.getString("City"));
        sz.setfIrSzam(rs.getInt("Postal Code"));
        sz.setfCim(rs.getString("Address"));
        sz.setMeret(rs.getInt("Size"));
        sz.setBecsErtek(rs.getInt("Value"));
        sz.setAllapot(rs.getString("Condition"));
        return sz;
    }

    /**
     * Delete loan (Can't undo!!)
     * @param id
     * @throws SQLException 
     */
    @Override
    public void LoanDelete(int id) throws SQLException {
        PreparedStatement deleteLoanById = this.getConnection().prepareStatement("delete from loan where `Id Loan` =?");
        deleteLoanById.setInt(1, id);
        deleteLoanById.executeUpdate();
    }

    // LTP ******************
    /**
     * Insert savings (Hungarian LTP) data to MySql database link with clients
     * @param adat 
     */
    @Override
    public void insertLtp(Ltp adat) {
        try {
            try (PreparedStatement insertNewLtp = this.getConnection().prepareStatement("INSERT INTO savings (`Id customer`,`Amount`,`Start`,`Term`,`End`,`Piece`) "
                    + "VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS)) {
                insertNewLtp.setInt(1, adat.getUgyfelId());
                insertNewLtp.setInt(2, adat.getSzerzOsszeg());
                insertNewLtp.setDate(3, Date.valueOf(adat.getLtpStart()));
                insertNewLtp.setInt(4, adat.getLtpFutamido());
                insertNewLtp.setDate(5, Date.valueOf(adat.getLtpEnd()));
                insertNewLtp.setInt(6, adat.getdBSzam());
                insertNewLtp.executeUpdate();
                ResultSet generatedKeys = insertNewLtp.getGeneratedKeys();

                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                }
            }

        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Modify savings
     * @param ltp 
     */
    @Override
    public void update(Ltp ltp) {
        try {
            PreparedStatement ltpUpdate = this.getConnection().prepareStatement("UPDATE savings SET `Amount`=?, `Start`=?, `Term`=?, `End`=?, `Piece`=? WHERE `Id Savings`=?");
            ltpUpdate.setInt(1, ltp.getSzerzOsszeg());
            ltpUpdate.setDate(2, Date.valueOf(ltp.getLtpStart()));
            ltpUpdate.setInt(3, ltp.getLtpFutamido());
            ltpUpdate.setDate(4, Date.valueOf(ltp.getLtpEnd()));
            ltpUpdate.setInt(5, ltp.getdBSzam());
            ltpUpdate.setString(6, ltp.getUgyfelId2());
            ltpUpdate.executeUpdate();
        } catch (SQLException e) {
            System.out.println("LTP SQLException" + e.getMessage());
        }
    }

    /**
     * List all savings
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Ltp> findAllLtp() throws SQLException {

        ResultSet all = this.getConnection().prepareStatement("SELECT * from savings").executeQuery();
        List<Ltp> retltp = makeLtpList(all);
        return retltp;
    }
    
/**
 * Find savings by Id
 * @param id
 * @return
 * @throws SQLException 
 */
    @Override
    public Ltp findbyIdLtp(int id) throws SQLException {
        PreparedStatement fIdLtp = this.getConnection().prepareStatement("SELECT * from savings WHERE `Id Savings`=?;");
        fIdLtp.setInt(1, id);
        ResultSet findbyIdLtp = fIdLtp.executeQuery();
        List<Ltp> retltp = makeLtpList(findbyIdLtp);
        for (Ltp ltp : retltp) {
            if (ltp.getUgyfelId() == id) {
                return ltp;
            }
        }
        return null;
    }

    /**
     * If you list all saving you can search inside
     * @param ValToSearch
     * @return
     * @throws SQLException 
     */
    @Override
    public List<Ltp> searchFromLtp(String ValToSearch) throws SQLException {
        ResultSet searchltp = this.getConnection().prepareStatement("SELECT `Id Savings`,Amount,Start,Term,End,Piece,`Id customer`,`Last Name`,`First Name` from savings, customer WHERE CONCAT(`Id Savings`,`Amount`, `Start`, `Term`, `End`, `Piece`,`Id Customer`, `Last Name`,`First Name`) LIKE '%" + ValToSearch + "%'").executeQuery();
        List<Ltp> retltp = makeLtpList(searchltp);
        return retltp;

    }

    // LTP lekérdezés
    private List<Ltp> makeLtpList(ResultSet rs) throws SQLException {
        List<Ltp> retltp = new ArrayList<>();
        while (rs.next()) {
            retltp.add(makeLtp(rs));
        }
        return retltp;
    }

    private Ltp makeLtp(ResultSet rs) throws SQLException {
        Ltp data = new Ltp();
        data.setUgyfelId2(rs.getString("Id customer"));
        data.setSzerzOsszeg(rs.getInt("Amount"));
        data.setLtpStart2(rs.getString("Start"));
        data.setLtpFutamido(rs.getInt("Term"));
        data.setLtpEnd2(rs.getString("End"));
        data.setdBSzam2(rs.getString("Piece"));
        data.setUgyfelId(rs.getInt("Id Savings"));

        return data;
    }

    /**
     * Delete savings (Can't undo!!)
     * @param id
     * @throws SQLException 
     */
    @Override
    public void LtpDelete(int id) throws SQLException {
        PreparedStatement deleteLtpById = this.getConnection().prepareStatement("delete from savings where `Id Savings` =?");
        deleteLtpById.setInt(1, id);
        deleteLtpById.executeUpdate();
    }

    //   Mixed lists ****************
    /**
     * You can list clients,loans,savings in one list
     * @return
     * @throws SQLException 
     */
    @Override
    public List<AllKindList> allKindList() throws SQLException {

        ResultSet searchAll = this.getConnection().prepareStatement("SELECT `customer`.`Id`,`loan`.`Id loan`,`savings`.`Id savings`,"
                + "`Last Name`, `First Name`,`loan`.`Amount`,`loan`.`Start`,`loan`.`End`, `savings`.`Amount`,`savings`.`Start`,"
                + "`savings`.`End`from loan,customer INNER JOIN Customer_to_Loan ON `Id customer`=`Id` "
                + "INNER JOIN savings ON `savings`.`Id customer`=`Id`;").executeQuery();

        List<AllKindList> allKindList = makeAllKindListsList(searchAll);
        return allKindList;
    }
     
    private List<AllKindList> makeAllKindListsList(ResultSet rs) throws SQLException {
        List<AllKindList> retall = new ArrayList<>();
        while (rs.next()) {
            retall.add(makefulllist(rs));
        }
        return retall;
    }

    /**
     * You can list clients,loans,savings in one list and search inside
     * @param ValToSearch
     * @return
     * @throws SQLException 
     */
    @Override
    public List<AllKindList> searhFromAllKindLists(String ValToSearch) throws SQLException {
        ResultSet searchAllKind = this.getConnection().prepareStatement("SELECT `customer`.`Id`,`loan`.`Id loan`,`savings`.`Id savings`,"
                + "`Last Name`, `First Name`,`loan`.`Amount`,`loan`.`Start`,`loan`.`End`, `savings`.`Amount`,`savings`.`Start`,"
                + "`savings`.`End`from loan,customer,savings,Customer_to_Loan WHERE CONCAT(`customer`.`Id`,`loan`.`Id loan`,`savings`.`Id savings`,"
                + "`Last Name`, `First Name`,`loan`.`Amount`,`loan`.`Start`,`loan`.`End`, `savings`.`Amount`,`savings`.`Start`,"
                + "`savings`.`End`) LIKE '%" + ValToSearch + "%'").executeQuery();
        List<AllKindList> allKindList = makeAllKindListsList(searchAllKind);
        return allKindList;
    }

    private AllKindList makefulllist(ResultSet rs) throws SQLException {
        AllKindList data = new AllKindList();
        data.setUgyfelId(rs.getString("Id"));
        data.setLoanId(rs.getString("Id loan"));
        data.setLtpId(rs.getString("Id savings"));
        data.setVezetekNev(rs.getString("Last Name"));
        data.setKeresztNevek(rs.getString("First Name"));
        data.setHitelOsszeg(rs.getString("loan.Amount"));
        data.setHiteStart(rs.getString("loan.Start"));
        data.setHiteEnd(rs.getString("loan.End"));
        data.setLtpOsszeg(rs.getString("savings.Amount"));
        data.setLtpStart(rs.getString("savings.Start"));
        data.setLtpEnd(rs.getString("savings.End"));
        return data;
    }
    
    /**
     * List loans with link clients
     * @return
     * @throws SQLException 
     */
     @Override
    public List<AllKindList> ClientLoanList() throws SQLException {
          ResultSet clientLoan = this.getConnection().prepareStatement("SELECT `customer`.`Id`,`loan`.`Id loan`,`Last Name`, `First Name`,`loan`.`Amount`,`loan`.`Start`,`loan`.`End` from loan,customer INNER JOIN Customer_to_Loan ON `Id customer`=`Id`;").executeQuery();
       List<AllKindList> allKindList = makeClientLoanLists(clientLoan);
        return allKindList;
    }
    
      private List<AllKindList> makeClientLoanLists (ResultSet rs) throws SQLException {
        List<AllKindList> retall = new ArrayList<>();
        while (rs.next()) {
            retall.add(makeClienLoan(rs));
        }
        return retall;
    }
      
       private AllKindList makeClienLoan (ResultSet rs) throws SQLException {
        AllKindList data = new AllKindList();
        data.setUgyfelId(rs.getString("Id"));
        data.setLoanId(rs.getString("Id loan"));
        
        data.setVezetekNev(rs.getString("Last Name"));
        data.setKeresztNevek(rs.getString("First Name"));
        data.setHitelOsszeg(rs.getString("loan.Amount"));
        data.setHiteStart(rs.getString("loan.Start"));
        data.setHiteEnd(rs.getString("loan.End"));
       
        return data;
    }

    // *****************
    public static void main(String[] args) throws SQLException {
        ReposDataBase insert = new dataBaseSql();
        dataBaseSql test = new dataBaseSql();
        ReposDataBase adatok = new dataBaseSql();
        List<AllKindList> loanlist = new ArrayList<>();
        test.allKindList();
        loanlist = test.allKindList();
        //    System.out.println(loanlist.get(1).getLtpId());

    }



}
