package main.java.model;

import java.util.Date;

public class BnkSeek {
    private String real;
    private String pzn;
    private String uer;
    private String rgn;
    private String ind;
    private String tnp;
    private String nnp;
    private String adr;
    private String rkc;
    private String namep;
    private String newnum;
    private String telefon;
    private String regn;
    private String okpo;
    private Date dt_izm;
    private String ksnp;
    private Date date_in;
    private Date date_ch;


    public BnkSeek(String real, String pzn, String uer, String rgn, String ind, String tnp, String nnp, String adr, String rkc, String namep,
                   String newnum, String telefon, String regn, String okpo, Date dt_izm, String ksnp, Date date_in, Date date_ch) {
        this.real = real;
        this.pzn = pzn;
        this.uer = uer;
        this.rgn = rgn;
        this.ind = ind;
        this.tnp = tnp;
        this.nnp = nnp;
        this.adr = adr;
        this.rkc = rkc;
        this.namep = namep;
        this.newnum = newnum;
        this.telefon = telefon;
        this.regn = regn;
        this.okpo = okpo;
        this.dt_izm = dt_izm;
        this.ksnp = ksnp;
        this.date_in = date_in;
        this.date_ch = date_ch;
    }


    public String getReal() {
        return real;
    }

    public String getPzn() {
        return pzn;
    }

    public String getUer() {
        return uer;
    }

    public String getRgn() {
        return rgn;
    }

    public String getInd() {
        return ind;
    }

    public String getTnp() {
        return tnp;
    }

    public String getNnp() {
        return nnp;
    }

    public String getAdr() {
        return adr;
    }

    public String getRkc() {
        return rkc;
    }

    public String getNamep() {
        return namep;
    }

    public String getNewnum() {
        return newnum;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getRegn() {
        return regn;
    }

    public String getOkpo() {
        return okpo;
    }

    public Date getDt_izm() {
        return dt_izm;
    }

    public String getKsnp() {
        return ksnp;
    }

    public Date getDate_in() {
        return date_in;
    }

    public Date getDate_ch() {
        return date_ch;
    }
}
