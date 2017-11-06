package main.java.dto;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class BnkSeekDto {
    private StringProperty real;
    private StringProperty pznName;
    private StringProperty uerName;
    private StringProperty rgnName;
    private StringProperty ind;
    private StringProperty tnpName;
    private StringProperty nnp;
    private StringProperty adr;
    private StringProperty rkc;
    private StringProperty namep;
    private StringProperty newnum;
    private StringProperty telefon;
    private StringProperty regn;
    private StringProperty okpo;
    private ObjectProperty<Date> dt_izm;
    private StringProperty ksnp;
    private ObjectProperty<Date> date_in;
    private ObjectProperty<Date> date_ch;


    public BnkSeekDto(String real, String pznName, String uerName, String rgnName, String ind, String tnpName,
                      String nnp, String adr, String rkc, String namep, String newnum, String telefon,
                      String regn, String okpo, Date dt_izm, String ksnp, Date date_in, Date date_ch) {
        this.real = new SimpleStringProperty(real);
        this.pznName = new SimpleStringProperty(pznName);
        this.uerName = new SimpleStringProperty(uerName);
        this.rgnName = new SimpleStringProperty(rgnName);
        this.ind = new SimpleStringProperty(ind);
        this.tnpName = new SimpleStringProperty(tnpName);
        this.nnp = new SimpleStringProperty(nnp);
        this.adr = new SimpleStringProperty(adr);
        this.rkc = new SimpleStringProperty(rkc);
        this.namep = new SimpleStringProperty(namep);
        this.newnum = new SimpleStringProperty(newnum);
        this.telefon = new SimpleStringProperty(telefon);
        this.regn = new SimpleStringProperty(regn);
        this.okpo = new SimpleStringProperty(okpo);
        this.dt_izm = new SimpleObjectProperty<>(dt_izm);
        this.ksnp = new SimpleStringProperty(ksnp);
        this.date_in = new SimpleObjectProperty<>(date_in);
        this.date_ch = new SimpleObjectProperty<>(date_ch);
    }


    public StringProperty namepProperty() {
        return namep;
    }

    public StringProperty newnumProperty() {
        return newnum;
    }


    public String getReal() {
        return real.get();
    }

    public String getPznName() {
        return pznName.get();
    }

    public String getUerName() {
        return uerName.get();
    }

    public String getRgnName() {
        return rgnName.get();
    }

    public String getInd() {
        return ind.get();
    }

    public String getTnpName() {
        return tnpName.get();
    }

    public String getNnp() {
        return nnp.get();
    }

    public String getAdr() {
        return adr.get();
    }

    public String getRkc() {
        return rkc.get();
    }

    public String getTelefon() {
        return telefon.get();
    }

    public String getRegn() {
        return regn.get();
    }

    public String getOkpo() {
        return okpo.get();
    }

    public Date getDt_izm() {
        return dt_izm.get();
    }

    public String getKsnp() {
        return ksnp.get();
    }

    public Date getDate_in() {
        return date_in.get();
    }

    public Date getDate_ch() {
        return date_ch.get();
    }


}
