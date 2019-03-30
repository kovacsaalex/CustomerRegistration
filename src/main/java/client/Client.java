package client;

import java.time.LocalDate;

/**
 *
 * @author ali
 */
public class Client {

    private int Id;
    private String email;
    private String vezetekNev;
    private String keresztNevek; // második név is
    private String leanyKoriNev;
    private String szulHely;
    private LocalDate szulIdo;
    private String anyuNeve;
    private String szemelyiSzam;
    private String adoAzonosito;
    private String tajSzam;
    private int iranyitoSzam;
    private String varos; // szűrés miatt venném külön
    private String lakCim; // utca, házszám, emelet, ajtó
    private String lakhelyido; //mióta lakik lakhelyén(lakcímkártya szerint)
    private String szIgSzam;
    private String lakCimSzam;
    private boolean hazas;
    private String telSzam;
    private int LoanID;
    

    public Client() {
    }

    public Client(int Id) {
        this.Id = Id;
    }
    
    

    public Client(String vezetekNev, String keresztNevek, String leanyKoriNev, LocalDate szulIdo, String anyuNeve) {
        this.vezetekNev = vezetekNev;
        this.keresztNevek = keresztNevek;
        this.leanyKoriNev = leanyKoriNev;
        this.szulIdo = szulIdo;
        this.anyuNeve = anyuNeve;
    }
    
    

    public Client(String email, String vezetekNev, String keresztNevek, String leanyKoriNev, String szulHely, LocalDate szulIdo, String anyuNeve, String szemelyiSzam, String adoAzonosito, String tajSzam, int iranyitoSzam, String varos, String lakCim, String lakhelyido, String szIgSzam, String lakCimSzam, boolean hazas, String telSzam) {
        this.email = email;
        this.vezetekNev = vezetekNev;
        this.keresztNevek = keresztNevek;
        this.leanyKoriNev = leanyKoriNev;
        this.szulHely = szulHely;
        this.szulIdo = szulIdo;
        this.anyuNeve = anyuNeve;
        this.szemelyiSzam = szemelyiSzam;
        this.adoAzonosito = adoAzonosito;
        this.tajSzam = tajSzam;
        this.iranyitoSzam = iranyitoSzam;
        this.varos = varos;
        this.lakCim = lakCim;
        this.lakhelyido = lakhelyido;
        this.szIgSzam = szIgSzam;
        this.lakCimSzam = lakCimSzam;
        this.hazas = hazas;
        this.telSzam = telSzam;
    }

    public Client(int Id, String email, String vezetekNev, String keresztNevek, String leanyKoriNev, String szulHely, LocalDate szulIdo, String anyuNeve, String szemelyiSzam, String adoAzonosito, String tajSzam, int iranyitoSzam, String varos, String lakCim, String lakhelyido, String szIgSzam, String lakCimSzam, boolean hazas, String telSzam) {
        this.Id = Id;
        this.email = email;
        this.vezetekNev = vezetekNev;
        this.keresztNevek = keresztNevek;
        this.leanyKoriNev = leanyKoriNev;
        this.szulHely = szulHely;
        this.szulIdo = szulIdo;
        this.anyuNeve = anyuNeve;
        this.szemelyiSzam = szemelyiSzam;
        this.adoAzonosito = adoAzonosito;
        this.tajSzam = tajSzam;
        this.iranyitoSzam = iranyitoSzam;
        this.varos = varos;
        this.lakCim = lakCim;
        this.lakhelyido = lakhelyido;
        this.szIgSzam = szIgSzam;
        this.lakCimSzam = lakCimSzam;
        this.hazas = hazas;
        this.telSzam = telSzam;
    }
    
    

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVezetekNev() {
        return vezetekNev;
    }

    public void setVezetekNev(String vezetekNev) {
        this.vezetekNev = vezetekNev;
    }

    public String getKeresztNevek() {
        return keresztNevek;
    }

    public void setKeresztNevek(String keresztNevek) {
        this.keresztNevek = keresztNevek;
    }

    public String getLeanyKoriNev() {
        return leanyKoriNev;
    }

    public void setLeanyKoriNev(String leanyKoriNev) {
        this.leanyKoriNev = leanyKoriNev;
    }

    public String getSzulHely() {
        return szulHely;
    }

    public void setSzulHely(String szulHely) {
        this.szulHely = szulHely;
    }

    public LocalDate getSzulIdo() {
        return szulIdo;
    }

    public void setSzulIdo(LocalDate szulIdo) {
        this.szulIdo = szulIdo;
    }

    public String getAnyuNeve() {
        return anyuNeve;
    }

    public void setAnyuNeve(String anyuNeve) {
        this.anyuNeve = anyuNeve;
    }

    public String getSzemelyiSzam() {
        return szemelyiSzam;
    }

    public void setSzemelyiSzam(String szemelyiSzam) {
        this.szemelyiSzam = szemelyiSzam;
    }

    public String getAdoAzonosito() {
        return adoAzonosito;
    }

    public void setAdoAzonosito(String adoAzonosito) {
        this.adoAzonosito = adoAzonosito;
    }

    public String getTajSzam() {
        return tajSzam;
    }

    public void setTajSzam(String tajSzam) {
        this.tajSzam = tajSzam;
    }

    public int getIranyitoSzam() {
        return iranyitoSzam;
    }

    public void setIranyitoSzam(int iranyitoSzam) {
        this.iranyitoSzam = iranyitoSzam;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public String getLakCim() {
        return lakCim;
    }

    public void setLakCim(String lakCim) {
        this.lakCim = lakCim;
    }

    public String getLakhelyido() {
        return lakhelyido;
    }

    public void setLakhelyido(String lakhelyido) {
        this.lakhelyido = lakhelyido;
    }

    public String getSzIgSzam() {
        return szIgSzam;
    }

    public void setSzIgSzam(String szIgSzam) {
        this.szIgSzam = szIgSzam;
    }

    public String getLakCimSzam() {
        return lakCimSzam;
    }

    public void setLakCimSzam(String lakCimSzam) {
        this.lakCimSzam = lakCimSzam;
    }

    public boolean isHazas() {
        return hazas;
    }

    public void setHazas(boolean hazas) {
        this.hazas = hazas;
    }

    public String getTelSzam() {
        return telSzam;
    }

    public void setTelSzam(String telSzam) {
        this.telSzam = telSzam;
    }

}
