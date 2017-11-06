package main.java.model;


import java.util.Date;

public class BnkSeekName extends BnkSeek {
    private String pznName;
    private String uerName;
    private String rgnName;
    private String tnpName;

    public BnkSeekName(String real, String pzn, String uer, String rgn, String ind, String tnp, String nnp, String adr, String rkc, String namep, String newnum, String telefon, String regn, String okpo, Date dt_izm, String ksnp, Date date_in, Date date_ch, String pznName, String uerName, String rgnName, String tnpName) {
        super(real, pzn, uer, rgn, ind, tnp, nnp, adr, rkc, namep, newnum, telefon, regn, okpo, dt_izm, ksnp, date_in, date_ch);
        this.pznName = pznName;
        this.uerName = uerName;
        this.rgnName = rgnName;
        this.tnpName = tnpName;
    }

    public String getPznName() {
        return pznName;
    }

    public String getUerName() {
        return uerName;
    }

    public String getRgnName() {
        return rgnName;
    }

    public String getTnpName() {
        return tnpName;
    }
}
