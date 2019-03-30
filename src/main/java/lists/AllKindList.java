package lists;

import java.time.LocalDate;

/**
 *
 * @author alexkovacs
 */
public class AllKindList {

    private String ugyfelId;
    private String loanId;
    private String ltpId;
    private String vezetekNev;
    private String keresztNevek;
    private String hitelOsszeg;
    private String hiteStart;
    private String hiteEnd;
    private String ltpOsszeg;
    private String ltpStart;
    private String ltpEnd;

    public AllKindList() {
    }

    public AllKindList(String ugyfelId, String loanId, String ltpId, String vezetekNev, String keresztNevek, String hitelOsszeg, String hiteStart, String hiteEnd, String ltpOsszeg, String ltpStart, String ltpEnd) {
        this.ugyfelId = ugyfelId;
        this.loanId = loanId;
        this.ltpId = ltpId;
        this.vezetekNev = vezetekNev;
        this.keresztNevek = keresztNevek;
        this.hitelOsszeg = hitelOsszeg;
        this.hiteStart = hiteStart;
        this.hiteEnd = hiteEnd;
        this.ltpOsszeg = ltpOsszeg;
        this.ltpStart = ltpStart;
        this.ltpEnd = ltpEnd;
    }

    public String getUgyfelId() {
        return ugyfelId;
    }

    public void setUgyfelId(String ugyfelId) {
        this.ugyfelId = ugyfelId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getLtpId() {
        return ltpId;
    }

    public void setLtpId(String ltpId) {
        this.ltpId = ltpId;
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

    public String getHitelOsszeg() {
        return hitelOsszeg;
    }

    public void setHitelOsszeg(String hitelOsszeg) {
        this.hitelOsszeg = hitelOsszeg;
    }

    public String getHiteStart() {
        return hiteStart;
    }

    public void setHiteStart(String hiteStart) {
        this.hiteStart = hiteStart;
    }

    public String getHiteEnd() {
        return hiteEnd;
    }

    public void setHiteEnd(String hiteEnd) {
        this.hiteEnd = hiteEnd;
    }

    public String getLtpOsszeg() {
        return ltpOsszeg;
    }

    public void setLtpOsszeg(String ltpOsszeg) {
        this.ltpOsszeg = ltpOsszeg;
    }

    public String getLtpStart() {
        return ltpStart;
    }

    public void setLtpStart(String ltpStart) {
        this.ltpStart = ltpStart;
    }

    public String getLtpEnd() {
        return ltpEnd;
    }

    public void setLtpEnd(String ltpEnd) {
        this.ltpEnd = ltpEnd;
    }
    
    


    

}
