package loan;

import java.time.LocalDate;

/**
 *
 * @author ali
 */
public class Loan {

    // hiteladatok
    private int ugyfelId;
    private String hitelTipus;
    private int osszeg;
    private LocalDate kezdet;
    private LocalDate lejarat;
    private int futamido; // honapokban
    private double kamatlab;
    private int hitelId;

    // fedezet adatok
    private String hrsz;
    private String fVaros;
    private String fCim;
    private int fIrSzam;
    private int meret;
    private int becsErtek;
    private String allapot;

    public Loan(int ugyfelId, String hitelTipus, int osszeg, LocalDate kezdet, LocalDate lejarat, int futamido, double kamatlab, String hrsz, String fVaros, String fCim, int fIrSzam, int meret, int becsErtek, String allapot) {
        this.ugyfelId = ugyfelId;
        this.hitelTipus = hitelTipus;
        this.osszeg = osszeg;
        this.kezdet = kezdet;
        this.lejarat = lejarat;
        this.futamido = futamido;
        this.kamatlab = kamatlab;
        this.hrsz = hrsz;
        this.fVaros = fVaros;
        this.fCim = fCim;
        this.fIrSzam = fIrSzam;
        this.meret = meret;
        this.becsErtek = becsErtek;
        this.allapot = allapot;
    }

    public Loan() {
    }
    
    
    public int getUgyfelId() {
        return ugyfelId;
    }

    public void setUgyfelId(int ugyfelId) {
        this.ugyfelId = ugyfelId;
    }

    public String getHitelTipus() {
        return hitelTipus;
    }

    public void setHitelTipus(String hitelTipus) {
        this.hitelTipus = hitelTipus;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }

    public LocalDate getKezdet() {
        return kezdet;
    }

    public void setKezdet(LocalDate kezdet) {
        this.kezdet = kezdet;
    }

    public LocalDate getLejarat() {
        return lejarat;
    }

    public void setLejarat(LocalDate lejarat) {
        this.lejarat = lejarat;
    }

    public int getFutamido() {
        return futamido;
    }

    public void setFutamido(int futamido) {
        this.futamido = futamido;
    }

    public double getKamatlab() {
        return kamatlab;
    }

    public void setKamatlab(double kamatlab) {
        this.kamatlab = kamatlab;
    }

    public String getHrsz() {
        return hrsz;
    }

    public void setHrsz(String hrsz) {
        this.hrsz = hrsz;
    }

    public String getfVaros() {
        return fVaros;
    }

    public void setfVaros(String fVaros) {
        this.fVaros = fVaros;
    }

    public String getfCim() {
        return fCim;
    }

    public void setfCim(String fCim) {
        this.fCim = fCim;
    }

    public int getfIrSzam() {
        return fIrSzam;
    }

    public void setfIrSzam(int fIrSzam) {
        this.fIrSzam = fIrSzam;
    }

    public int getMeret() {
        return meret;
    }

    public void setMeret(int meret) {
        this.meret = meret;
    }

    public int getBecsErtek() {
        return becsErtek;
    }

    public void setBecsErtek(int becsErtek) {
        this.becsErtek = becsErtek;
    }

    public String getAllapot() {
        return allapot;
    }

    public void setAllapot(String allapot) {
        this.allapot = allapot;
    }

    public int getHitelId() {
        return hitelId;
    }

    public void setHitelId(int hitelId) {
        this.hitelId = hitelId;
    }
    
    

}
