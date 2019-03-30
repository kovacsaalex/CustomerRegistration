package ltp;


import java.time.LocalDate;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ali
 */
public class Ltp {
    
    private int ugyfelId;
    private int szerzOsszeg;
    private LocalDate ltpStart;
    private int LtpFutamido; // hónapban
    private LocalDate ltpEnd;
    private int dBSzam;

    private String ugyfelId2;
    private String szerzOsszeg2;
    private String ltpStart2;
    private String LtpFutamido2; // hónapban
    private String ltpEnd2;
    private String dBSzam2;

    public Ltp() {
    }
    
    
    
    public Ltp(int ugyfelId, int szerzOsszeg, LocalDate ltpStart, int LtpFutamido, LocalDate ltpEnd, int dBSzam) {
        this.ugyfelId = ugyfelId;
        this.szerzOsszeg = szerzOsszeg;
        this.ltpStart = ltpStart;
        this.LtpFutamido = LtpFutamido;
        this.ltpEnd = ltpEnd;
        this.dBSzam = dBSzam;
    }

    public Ltp(String ugyfelId2, String szerzOsszeg2, String ltpStart2, String LtpFutamido2, String ltpEnd2, String dBSzam2) {
        this.ugyfelId2 = ugyfelId2;
        this.szerzOsszeg2 = szerzOsszeg2;
        this.ltpStart2 = ltpStart2;
        this.LtpFutamido2 = LtpFutamido2;
        this.ltpEnd2 = ltpEnd2;
        this.dBSzam2 = dBSzam2;
    }

    public Ltp(int ugyfelId, int szerzOsszeg, LocalDate ltpStart, int LtpFutamido, LocalDate ltpEnd, int dBSzam, String ugyfelId2) {
        this.ugyfelId = ugyfelId;
        this.szerzOsszeg = szerzOsszeg;
        this.ltpStart = ltpStart;
        this.LtpFutamido = LtpFutamido;
        this.ltpEnd = ltpEnd;
        this.dBSzam = dBSzam;
        this.ugyfelId2 = ugyfelId2;
    }
    

   
    public int getUgyfelId() {
        return ugyfelId;
    }

    public void setUgyfelId(int ugyfelId) {
        this.ugyfelId = ugyfelId;
    }

    public int getSzerzOsszeg() {
        return szerzOsszeg;
    }

    public void setSzerzOsszeg(int szerzOsszeg) {
        this.szerzOsszeg = szerzOsszeg;
    }

    public LocalDate getLtpStart() {
        return ltpStart;
    }

    public void setLtpStart(LocalDate ltpStart) {
        this.ltpStart = ltpStart;
    }

    public int getLtpFutamido() {
        return LtpFutamido;
    }

    public void setLtpFutamido(int LtpFutamido) {
        this.LtpFutamido = LtpFutamido;
    }

    public LocalDate getLtpEnd() {
        return ltpEnd;
    }

    public void setLtpEnd(LocalDate ltpEnd) {
        this.ltpEnd = ltpEnd;
    }

    public int getdBSzam() {
        return dBSzam;
    }

    public void setdBSzam(int dBSzam) {
        this.dBSzam = dBSzam;
    }

    
   //

    public String getUgyfelId2() {
        return ugyfelId2;
    }

    public void setUgyfelId2(String ugyfelId2) {
        this.ugyfelId2 = ugyfelId2;
    }

    public String getSzerzOsszeg2() {
        return szerzOsszeg2;
    }

    public void setSzerzOsszeg2(String szerzOsszeg2) {
        this.szerzOsszeg2 = szerzOsszeg2;
    }

    public String getLtpStart2() {
        return ltpStart2;
    }

    public void setLtpStart2(String ltpStart2) {
        this.ltpStart2 = ltpStart2;
    }

    public String getLtpFutamido2() {
        return LtpFutamido2;
    }

    public void setLtpFutamido2(String LtpFutamido2) {
        this.LtpFutamido2 = LtpFutamido2;
    }

    public String getLtpEnd2() {
        return ltpEnd2;
    }

    public void setLtpEnd2(String ltpEnd2) {
        this.ltpEnd2 = ltpEnd2;
    }

    public String getdBSzam2() {
        return dBSzam2;
    }

    public void setdBSzam2(String dBSzam2) {
        this.dBSzam2 = dBSzam2;
    }
    
    
    
    

    

    

    
    
    
    
}
