
package repository;

import client.Client;
import java.util.List;
import loan.Loan;
import ltp.Ltp;

/**
 *
 * @author alexkovacs
 */
public interface ReposExcel {

    List<Client> findAllClients();

    List<Loan> findAllLoans();

    List<Ltp> findAllLtps();
 
}
