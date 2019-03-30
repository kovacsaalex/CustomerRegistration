package repository;

import client.Client;
import java.sql.SQLException;
import java.util.List;
import lists.AllKindList;
import loan.Loan;
import ltp.Ltp;

/**
 *
 * @author alexkovacs
 */
public interface ReposDataBase {

    // insertek
    void insertClient(Client adat) throws SQLException;

    void insertClientToLoan(Client adat) throws SQLException;

    void insertLoan(Loan adat) throws SQLException;

    void insertLtp(Ltp adat) throws SQLException;

    // modosítások
    void update(Client client);

    void update(Loan loan);

    void update(Ltp ltp);

    // lekérdezések
    List<Client> findAllClients() throws SQLException;

    List<Loan> findAllLoans() throws SQLException;

    List<Ltp> findAllLtp() throws SQLException;

    Client findbyIdClients(int id) throws SQLException;

    Loan findByIdLoan(int id) throws SQLException;

    Ltp findbyIdLtp(int id) throws SQLException;

    List<Client> searchFromClients(String ValToSearch) throws SQLException;

    List<Ltp> searchFromLtp(String ValToSearch) throws SQLException;

    List<Loan> searchFromLoan(String ValToSearch) throws SQLException;
    
    List<AllKindList> searhFromAllKindLists (String ValToSearch) throws SQLException;
    
    List<AllKindList> allKindList () throws SQLException;
    
    List<AllKindList> ClientLoanList () throws SQLException;

    int sqlIdCount();
    
    // törlés
    
    void ClientDelete (int id) throws SQLException;
    
    void LoanDelete (int id) throws SQLException;
    
    void LtpDelete (int id) throws SQLException;

}
