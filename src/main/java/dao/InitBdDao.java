package main.java.dao;

import main.java.bd.JdbcTemplate;
import main.java.bd.register.JdbcTemplateSqlite;

public class InitBdDao {

    //todo ПЕРЕНЕСТИ В СКРИПТЫ

    private JdbcTemplate jdbcTemplate;

    public InitBdDao() {
        this.jdbcTemplate = new JdbcTemplateSqlite();
    }

    public void init() {
        String sqlCreate__Participant_Settlement = "CREATE TABLE IF NOT EXISTS Participant_Settlement (pzn TEXT PRIMARY KEY NOT NULL, imy TEXT, name TEXT);";
        jdbcTemplate.executeUpdate(sqlCreate__Participant_Settlement);

        String sqlCreate__Elect_Participant = "CREATE TABLE IF NOT EXISTS Elect_Participant (uer TEXT, name TEXT);";
        jdbcTemplate.executeUpdate(sqlCreate__Elect_Participant);

        String sqlCreate__Region = "CREATE TABLE IF NOT EXISTS Region (rgn TEXT PRIMARY KEY NOT NULL, name TEXT);";
        jdbcTemplate.executeUpdate(sqlCreate__Region);

        String sqlCreate__Type_Locality = "CREATE TABLE IF NOT EXISTS Type_Locality (tnp TEXT PRIMARY KEY NOT NULL, name TEXT);";
        jdbcTemplate.executeUpdate(sqlCreate__Type_Locality);


        String sqlCreate__Bnk_Seek = "CREATE TABLE IF NOT EXISTS Bnk_Seek(" +
                "real TEXT, pzn TEXT, uer TEXT NOT NULL, rgn TEXT NOT NULL, ind TEXT, tnp TEXT, nnp TEXT, adr TEXT, " +
                "rkc TEXT, namep TEXT NOT NULL, newnum TEXT PRIMARY KEY NOT NULL, telefon TEXT, regn TEXT, okpo TEXT, " +
                "dt_izm TEXT NOT NULL, ksnp TEXT, date_in TEXT NOT NULL, date_ch TEXT, " +
                "FOREIGN KEY (pzn) REFERENCES Participant_Settlement (pzn), " +
                "FOREIGN KEY (uer) REFERENCES Elect_Participant (uer), " +
                "FOREIGN KEY (rgn) REFERENCES Region (rgn), " +
                "FOREIGN KEY (tnp) REFERENCES Type_Locality (tnp) );";
        jdbcTemplate.executeUpdate(sqlCreate__Bnk_Seek);
    }
}
