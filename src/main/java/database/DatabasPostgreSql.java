package database;

import client.Client;
import lists.AllKindList;
import loan.Loan;
import ltp.Ltp;
import repository.ReposDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabasPostgreSql    {

   /* DbConnectSql cn = new DbConnectSql();
    int id = 0;

    public Connection getConnection() {
        return cn.getConn();
    }

    @Override
    public int sqlIdCount() {
        return id;
    }

    @Override
    public void insertClient(Client adat) throws SQLException {

    }

    @Override
    public void insertClientToLoan(Client adat) throws SQLException {

    }

    @Override
    public void insertLoan(Loan adat) throws SQLException {

    }

    @Override
    public void insertLtp(Ltp adat) throws SQLException {

    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void update(Loan loan) {

    }

    @Override
    public void update(Ltp ltp) {

    }

    @Override
    public List<Client> findAllClients() throws SQLException {
        // ResultSet all = this.getConnection().prepareStatement("SELECT * from customer").executeQuery();
        ResultSet all = this.getConnection().prepareStatement("SELECT * from admindatabase.customer").executeQuery();
        List<Client> ret = makeList(all);
        return ret;
    }



    @Override
    public List<Loan> findAllLoans() throws SQLException {
        return null;
    }

    @Override
    public List<Ltp> findAllLtp() throws SQLException {
        return null;
    }

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

    @Override
    public Loan findByIdLoan(int id) throws SQLException {
        return null;
    }

    @Override
    public Ltp findbyIdLtp(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Client> searchFromClients(String ValToSearch) throws SQLException {
        return null;
    }

    @Override
    public List<Ltp> searchFromLtp(String ValToSearch) throws SQLException {
        return null;
    }

    @Override
    public List<Loan> searchFromLoan(String ValToSearch) throws SQLException {
        return null;
    }

    @Override
    public List<AllKindList> searhFromAllKindLists(String ValToSearch) throws SQLException {
        return null;
    }

    @Override
    public List<AllKindList> allKindList() throws SQLException {
        return null;
    }

    @Override
    public List<AllKindList> ClientLoanList() throws SQLException {
        return null;
    }



    @Override
    public void ClientDelete(int id) throws SQLException {

    }

    @Override
    public void LoanDelete(int id) throws SQLException {

    }

    @Override
    public void LtpDelete(int id) throws SQLException {

    }

    // Client
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
        sz.setVezetekNev(rs.getString("Last_Name"));
        sz.setKeresztNevek(rs.getString("First_Name"));
        sz.setLeanyKoriNev(rs.getString("Maiden_Name"));
        sz.setEmail(rs.getString("Email"));
        sz.setSzulHely(rs.getString("Birth_Date"));
     *//*   sz.setAnyuNeve(rs.getString("Mother_Name"));
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
        sz.setSzulIdo(rs.getDate("Birth date").toLocalDate());*//*
        return sz;
    }
    //*/
}
