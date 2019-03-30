
package readExcel;

import client.Client;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import loan.Loan;
import ltp.Ltp;
import repository.ReposExcel;

/**
 *
 * @author alexkovacs
 */
public class DataExcel extends ReadExcel implements ReposExcel{
    
    private DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
    private final ArrayList<Client> clientExcels = new ArrayList<>();
    private final ArrayList<Loan> loanExcels = new ArrayList<>();
    private final ArrayList<Ltp> ltpExcels = new ArrayList<>();
    private Client clientValues;
    private Loan loanValues;
    private Ltp ltpValues;

    public DataExcel(String fileName) throws IOException {
        super(fileName);
        
    }
    
    

    @Override
    public List<Client> findAllClients() {
          clientValues = new Client("Valami", getDataFromExcels().get(1), getDataFromExcels().get(2),
                getDataFromExcels().get(3), getDataFromExcels().get(4), LocalDate.parse(getDataFromExcels().get(5), dtf),
                getDataFromExcels().get(6), getDataFromExcels().get(7), getDataFromExcels().get(8),
                getDataFromExcels().get(9), Integer.parseInt(getDataFromExcels().get(10)), getDataFromExcels().get(11),
                getDataFromExcels().get(12), getDataFromExcels().get(13), getDataFromExcels().get(14),
                getDataFromExcels().get(15), Boolean.valueOf(getDataFromExcels().get(16)), getDataFromExcels().get(17));
        clientExcels.add(clientValues);

        return this.clientExcels;
    }

    @Override
    public List<Loan> findAllLoans() {
        loanValues = new Loan(Integer.parseInt(getDataFromExcels().get(0)), getDataFromExcels().get(1), Integer.parseInt(getDataFromExcels().get(2)),
                LocalDate.parse(getDataFromExcels().get(3), dtf), LocalDate.parse(getDataFromExcels().get(4), dtf),
                Integer.parseInt(getDataFromExcels().get(5)), Double.parseDouble(getDataFromExcels().get(6)),
                getDataFromExcels().get(7), getDataFromExcels().get(8), getDataFromExcels().get(9), Integer.parseInt(getDataFromExcels().get(10)),
                Integer.parseInt(getDataFromExcels().get(11)), Integer.parseInt(getDataFromExcels().get(12)), getDataFromExcels().get(13));

        loanExcels.add(loanValues);

        return this.loanExcels;
    }

    @Override
    public List<Ltp> findAllLtps() {
          ltpValues = new Ltp(getDataFromExcels().get(0), getDataFromExcels().get(1), getDataFromExcels().get(2),
                getDataFromExcels().get(3), getDataFromExcels().get(4), getDataFromExcels().get(5));
        ltpExcels.add(ltpValues);

        return this.ltpExcels;
    } 
    
}
