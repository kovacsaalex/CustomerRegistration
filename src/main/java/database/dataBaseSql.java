package database;

import client.Client;
import lists.AllKindList;
import loan.Loan;
import ltp.Ltp;
import repository.ReposDataBase;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class make SQL Query with MySql database
 */
public class dataBaseSql implements ReposDataBase {

    DbConnectSql cn = new DbConnectSql();
    Props props = new Props();
    int id = 0;



    public dataBaseSql() {
    }


    public Connection getConnection() {
        return cn.getConnection();
    }

    /**
     * id változások visszajelzése (Ha a rögzités sikeres) / if add a new client successfully get an Id
     *
     * @return
     */

    @Override
    public int sqlIdCount() {
        return id;
    }

    // Client ******************//

    /**
     * Insert new client to the MySQL database with personal data
     *
     * @param adat
     */
    @Override
    public void insertClient(Client adat) {

        //  try (PreparedStatement insertNewClient = this.getConnection().prepareStatement( props.getInsertClient(), PreparedStatement.RETURN_GENERATED_KEYS)) {
        try (PreparedStatement insertNewClient = this.getConnection().prepareStatement(props.getInsertClient())) {

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
            System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/");
            System.out.println("Adat: Lakcím: "+ adat.getLakCim());
            insertNewClient.setString(13, adat.getLakhelyido());
            insertNewClient.setString(14, adat.getSzIgSzam());
            System.out.println("Id: "+ adat.getSzIgSzam());
            insertNewClient.setString(15, adat.getLakCimSzam());
            System.out.println("Lak: "+ adat.getLakCimSzam());
            insertNewClient.setString(16, adat.getTelSzam());

            // if you use MySql - use this
            //   insertNewClient.setDate(17, Date.valueOf(adat.getSzulIdo()));
            // if you use PostgreSql use this

            String test3 = adat.getSzulIdo().toString().replace("-", "");
            LocalDate lc = LocalDate.parse(test3, DateTimeFormatter.BASIC_ISO_DATE);
            insertNewClient.setDate(17, Date.valueOf(lc));
            insertNewClient.executeUpdate();

           /* ResultSet generatedKeys = insertNewClient.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }*/


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * loan data link with the clients
     *
     * @param adat
     * @throws SQLException
     */
    @Override
    public void insertClientToLoan(Client adat) {
      //  try (PreparedStatement insertNewClient = this.getConnection().prepareStatement(props.getInsertClientToLoan(), PreparedStatement.RETURN_GENERATED_KEYS)) {
            try (PreparedStatement insertNewClient = this.getConnection().prepareStatement(props.getInsertClientToLoan())) {
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
            // if you use MySql - use this
            //   insertNewClient.setDate(17, Date.valueOf(adat.getSzulIdo()));
            // if you use PostgreSql use this

           String test3 = adat.getSzulIdo().toString().replace("-", "");
            LocalDate lc = LocalDate.parse(test3, DateTimeFormatter.BASIC_ISO_DATE);
            insertNewClient.setDate(17, Date.valueOf(lc));

            insertNewClient.executeUpdate();
            ResultSet generatedKeys = insertNewClient.getGeneratedKeys();
            if (generatedKeys.next()) {
                System.out.println("hív");
                id = generatedKeys.getInt(1);
                PreparedStatement insertCToL = this.getConnection().prepareStatement(props.getInsertCToL());
                insertCToL.setInt(1, id);
                insertCToL.setInt(2, adat.getId());
                insertCToL.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Hiba az ügyfél felvitele közben / Error insert client" + ex.getMessage());
        }
    }

    /**
     * List all clients from the database
     */
    @Override
    public List<Client> findAllClients() throws SQLException, NullPointerException {
        ResultSet all = this.getConnection().prepareStatement(props.getFindAllClients()).executeQuery();
        List<Client> ret = makeList(all);
        return ret;
    }

    /**
     * Find client in the database by ID
     */
    @Override
    public Client findbyIdClients(int id) throws SQLException {

        PreparedStatement fIdClient = this.getConnection().prepareStatement(props.getFindbyIdClients());
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
     *
     * @param ValToSearch
     * @return
     * @throws SQLException
     */
    @Override
    public List<Client> searchFromClients(String ValToSearch) throws SQLException {
        ResultSet searchClient = this.getConnection().
                prepareStatement(props.getSearchFromClients() + ValToSearch + "%'").executeQuery();
        List<Client> ret = makeList(searchClient);
        return ret;
    }

    /**
     * Modify client
     *
     * @param client
     */
    @Override
    public void update(Client client) throws SQLException, NullPointerException {

        PreparedStatement clientUpdate = this.getConnection().prepareStatement(props.getClientUpdate());

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
        // if you use MySql - use this
       //  clientUpdate.setDate(17, Date.valueOf(client.getSzulIdo()));
        // if you use PostgreSql use this

        String test3 = client.getSzulIdo().toString().replace("-", "");
        LocalDate lc = LocalDate.parse(test3, DateTimeFormatter.BASIC_ISO_DATE);

         clientUpdate.setDate(17, Date.valueOf(lc));

        clientUpdate.setInt(18, client.getId());

        clientUpdate.executeUpdate();
    }

    private List<Client> makeList(ResultSet rs) throws SQLException, NullPointerException {
        List<Client> ret = new ArrayList<>();
        while (rs.next()) {
            ret.add(makeOne(rs));
        }
        return ret;
    }


    private Client makeOne(ResultSet rs) throws SQLException{
      
        Client sz = new Client();
        sz.setId(rs.getInt("id"));
        sz.setVezetekNev(rs.getString("Last_Name"));
        sz.setKeresztNevek(rs.getString("First_Name"));
        sz.setLeanyKoriNev(rs.getString("Maiden_Name"));
        sz.setEmail(rs.getString("Email"));
        sz.setSzulHely(rs.getString("Birth_Place"));
        sz.setAnyuNeve(rs.getString("Mother_Name"));
        sz.setSzemelyiSzam(rs.getString("Personal_Identification_Number"));
        sz.setAdoAzonosito(rs.getString("Tax_Number"));
        sz.setTajSzam(rs.getString("Social_Security_Number"));
        sz.setIranyitoSzam(rs.getInt("Postal_Code"));
        sz.setVaros(rs.getString("City"));
        sz.setLakCim(rs.getString("Address"));
        System.out.println("//////////////////////");
        System.out.println(rs.getString("Address"));
        
        sz.setLakhelyido(rs.getString("Moving_Time"));
        sz.setSzIgSzam(rs.getString("ID_Card_Number"));
        System.out.println("Id: "+rs.getString("ID_Card_Number"));
        
        sz.setLakCimSzam(rs.getString("Address_Card_Number"));
         System.out.println("Lakcím: "+rs.getString("Address_Card_Number"));
         System.out.println("//////////////////////");
        sz.setTelSzam(rs.getString("Phone_Number"));
        System.out.println(rs.getDate("Birth_date"));

        // if you use MySql - use this
        //  sz.setSzulIdo(rs.getDate("Birth_date").toLocalDate());

        // if you use PostgreSql use this
         try {
            sz.setSzulIdo(rs.getDate("Birth_date").toLocalDate());
            
        } catch (SQLException | NullPointerException e) {
           // System.out.println("Hiányzó adat! (DatabaseSql) "+e.getLocalizedMessage());
           e.getLocalizedMessage();
        }

       return sz;

    }

    /**
     * Delete client from the database (Can't undo!!)
     *
     * @param id
     * @throws SQLException
     */
    @Override
    public void ClientDelete(int id) throws SQLException {
        PreparedStatement deleteClientById = this.getConnection().prepareStatement(props.getClientDelete());
        deleteClientById.setInt(1, id);
        deleteClientById.executeUpdate();
    }

    // Loan ******************

    /**
     * Insert new Loan to the MySQL database with data
     *
     * @param adat
     */
    @Override
    public void insertLoan(Loan adat) {
        try {
            PreparedStatement insertNewLoan = this.getConnection().prepareStatement(props.getInsertLoan(), PreparedStatement.RETURN_GENERATED_KEYS);

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

                PreparedStatement insertCToL = this.getConnection().prepareStatement(props.getInsertCToL());
                insertCToL.setInt(1, adat.getUgyfelId());

                insertCToL.setInt(2, id);

                insertCToL.executeUpdate();

            }

            insertNewLoan.close();
        } catch (SQLException e) {
            System.out.println("Hiba az hitel felvitele közben / Error insert loan" + e.getMessage() + e.getSQLState());
        }
    }

    /**
     * Modify loan data
     *
     * @param loan
     */
    @Override
    public void update(Loan loan) {
        try {

            PreparedStatement loanupdate = this.getConnection().prepareStatement(props.getLoanUpdate());
            loanupdate.setString(1, loan.getHitelTipus());
            loanupdate.setInt(2, loan.getOsszeg());
            System.out.println(loan.getOsszeg());
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
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Loan> findAllLoans() throws SQLException {
        ResultSet all = this.getConnection().prepareStatement(props.getFindAllLoans()).executeQuery();
        List<Loan> retltp = makeLoanList(all);
        return retltp;
    }

    /**
     * find loan by Id
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Loan findByIdLoan(int id) throws SQLException {
        PreparedStatement fIdLoan = this.getConnection().prepareStatement(props.getFindByIdLoan());
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
     *
     * @param ValToSearch
     * @return
     * @throws SQLException
     */
    @Override
    public List<Loan> searchFromLoan(String ValToSearch) throws SQLException {

        ResultSet searchloan = this.getConnection().prepareStatement(props.getSearchFromLoan() + ValToSearch + "%'").executeQuery();

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

    private Loan makeLoanOne(ResultSet rs) throws SQLException, NullPointerException {
        Loan sz = new Loan();
        sz.setUgyfelId(rs.getInt("Id_loan"));
        sz.setHitelTipus(rs.getString("Type"));
        sz.setOsszeg(rs.getInt("Amount"));


        try {
            sz.setKezdet(LocalDate.parse(rs.getString("Start")));
            sz.setLejarat(LocalDate.parse(rs.getString("End")));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        sz.setFutamido(rs.getInt("Term"));
        sz.setKamatlab(rs.getDouble("Interest_Rate"));
        sz.setHrsz(rs.getString("Hrsz"));
        sz.setfVaros(rs.getString("City"));
        sz.setfIrSzam(rs.getInt("Postal_Code"));
        sz.setfCim(rs.getString("Address"));
        sz.setMeret(rs.getInt("Size"));
        sz.setBecsErtek(rs.getInt("Value"));
        sz.setAllapot(rs.getString("Condition"));
        return sz;
    }

    /**
     * Delete loan (Can't undo!!)
     *
     * @param id
     * @throws SQLException
     */

    @Override
    public void LoanDelete(int id) throws SQLException {
        PreparedStatement deleteLoanById = this.getConnection().prepareStatement(props.getLoanDelete());
        deleteLoanById.setInt(1, id);
        deleteLoanById.executeUpdate();
    }

    // LTP ******************

    /**
     * Insert savings (Hungarian LTP) data to MySql database link with clients
     *
     * @param adat
     */
    @Override
    public void insertLtp(Ltp adat) {
        try {
    //        try (PreparedStatement insertNewLtp = this.getConnection().prepareStatement(props.getInsertLtp(), PreparedStatement.RETURN_GENERATED_KEYS)) {
                try (PreparedStatement insertNewLtp = this.getConnection().prepareStatement(props.getInsertLtp())) {
                insertNewLtp.setInt(1, adat.getUgyfelId());
                insertNewLtp.setInt(2, adat.getSzerzOsszeg());
                insertNewLtp.setDate(3, Date.valueOf(adat.getLtpStart()));
                insertNewLtp.setInt(4, adat.getLtpFutamido());
                insertNewLtp.setDate(5, Date.valueOf(adat.getLtpEnd()));
                insertNewLtp.setInt(6, adat.getdBSzam());
                insertNewLtp.executeUpdate();
                ResultSet generatedKeys = insertNewLtp.getGeneratedKeys();

             /*   if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                }*/
            }

        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Modify savings
     *
     * @param ltp
     */
    @Override
    public void update(Ltp ltp) {
        try {
            PreparedStatement ltpUpdate = this.getConnection().prepareStatement(props.getLtpUpdate());
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
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Ltp> findAllLtp() throws SQLException {

        ResultSet all = this.getConnection().prepareStatement(props.getFindAllLtp()).executeQuery();
        List<Ltp> retltp = makeLtpList(all);
        return retltp;
    }

    /**
     * Find savings by Id
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Ltp findbyIdLtp(int id) throws SQLException {
        PreparedStatement fIdLtp = this.getConnection().prepareStatement(props.getFindbyIdLtp());
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
     *
     * @param ValToSearch
     * @return
     * @throws SQLException
     */
    @Override
    public List<Ltp> searchFromLtp(String ValToSearch) throws SQLException {
        ResultSet searchltp = this.getConnection().prepareStatement(props.getSearchFromLtp() + ValToSearch + "%'").executeQuery();
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
        data.setUgyfelId2(rs.getString("Id_customer"));
        data.setSzerzOsszeg(rs.getInt("Amount"));
        data.setLtpStart2(rs.getString("Start"));
        data.setLtpFutamido(rs.getInt("Term"));
        data.setLtpEnd2(rs.getString("End"));
        data.setdBSzam2(rs.getString("Piece"));
        data.setUgyfelId(rs.getInt("Id_savings"));

        return data;
    }

    /**
     * Delete savings (Can't undo!!)
     *
     * @param id
     * @throws SQLException
     */
    @Override
    public void LtpDelete(int id) throws SQLException {
        PreparedStatement deleteLtpById = this.getConnection().prepareStatement(props.getLtpDelete());
        deleteLtpById.setInt(1, id);
        deleteLtpById.executeUpdate();
    }

    //   Mixed lists ****************

    /**
     * You can list clients,loans,savings in one list
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<AllKindList> allKindList() throws SQLException {

      /*  ResultSet searchAll = this.getConnection().prepareStatement("SELECT `customer`.`Id`,`loan`.`Id_loan`,`savings`.`Id_savings`,"
                + "`Last_Name`, `First_Name`,`loan`.`Amount`,`loan`.`Start`,`loan`.`End`, `savings`.`Amount`,`savings`.`Start`,"
                + "`savings`.`End`from loan,customer INNER JOIN Customer_to_Loan ON `Id_customer`=`Id` "
                + "INNER JOIN savings ON `savings`.`Id_customer`=`Id`;").executeQuery();*/
        ResultSet searchAll = this.getConnection().prepareStatement(props.getAllKindList()).executeQuery();

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
     *
     * @param ValToSearch
     * @return
     * @throws SQLException
     */
    @Override
    public List<AllKindList> searhFromAllKindLists(String ValToSearch) throws SQLException {
      /*  ResultSet searchAllKind = this.getConnection().prepareStatement("SELECT `customer`.`Id`,`loan`.`Id_loan`,`savings`.`Id_savings`,"
                + "`Last_Name`, `First_Name`,`loan`.`Amount`,`loan`.`Start`,`loan`.`End`, `savings`.`Amount`,`savings`.`Start`,"
                + "`savings`.`End`from loan,customer,savings,Customer_to_Loan WHERE CONCAT(`customer`.`Id`,`loan`.`Id_loan`,`savings`.`Id_savings`,"
                + "`Last_Name`, `First_Name`,`loan`.`Amount`,`loan`.`Start`,`loan`.`End`, `savings`.`Amount`,`savings`.`Start`,"
                + "`savings`.`End`) LIKE '%" + ValToSearch + "%'").executeQuery();*/
        ResultSet searchAllKind = this.getConnection().prepareStatement(props.getSearhFromAllKindLists() + ValToSearch + "%'").executeQuery();
        List<AllKindList> allKindList = makeAllKindListsList(searchAllKind);
        return allKindList;
    }

    private AllKindList makefulllist(ResultSet rs) throws SQLException {
        AllKindList data = new AllKindList();
        data.setUgyfelId(rs.getString("Id"));
        data.setLoanId(rs.getString("Id_loan"));
        data.setLtpId(rs.getString("Id_savings"));
        data.setVezetekNev(rs.getString("Last_Name"));
        data.setKeresztNevek(rs.getString("First_Name"));
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
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<AllKindList> ClientLoanList() throws SQLException {
        //   ResultSet clientLoan = this.getConnection().prepareStatement("SELECT `customer`.`Id`,`loan`.`Id_loan`,`Last_Name`, `First_Name`,`loan`.`Amount`,`loan`.`Start`,`loan`.`End` from loan,customer INNER JOIN Customer_to_Loan ON `Id_customer`=`Id`;").executeQuery();
        ResultSet clientLoan = this.getConnection().prepareStatement(props.getClientLoanList()).executeQuery();
        List<AllKindList> allKindList = makeClientLoanLists(clientLoan);
        return allKindList;
    }

    private List<AllKindList> makeClientLoanLists(ResultSet rs) throws SQLException {
        List<AllKindList> retall = new ArrayList<>();
        while (rs.next()) {
            retall.add(makeClienLoan(rs));
        }
        return retall;
    }

    private AllKindList makeClienLoan(ResultSet rs) throws SQLException {
        AllKindList data = new AllKindList();
        data.setUgyfelId(rs.getString("Id"));
        data.setLoanId(rs.getString("Id_loan"));

        data.setVezetekNev(rs.getString("Last_Name"));
        data.setKeresztNevek(rs.getString("First_Name"));
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
