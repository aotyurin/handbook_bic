package main.java.dao;

import main.java.bd.JdbcTemplate;
import main.java.bd.register.JdbcTemplateOdbc;
import main.java.model.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdbcDirectoriesDao {
    private JdbcTemplate jdbcTemplate;

    public OdbcDirectoriesDao() {
        this.jdbcTemplate = new JdbcTemplateOdbc();
    }


    public List<BnkSeek> getBnkSeek() throws SQLException {
        String sql = "SELECT * FROM BNKSEEK";

        List<BnkSeek> bnkSeekList = new ArrayList<>();
        ResultSet resultSet = jdbcTemplate.executeQuery(sql);
        while (resultSet.next()) {
            String real = resultSet.getString("REAL");
            String pzn = resultSet.getString("PZN");
            String uer = resultSet.getString("UER");
            String rgn = resultSet.getString("RGN");
            String ind = resultSet.getString("IND");
            String tnp = resultSet.getString("TNP");
            String nnp = resultSet.getString("NNP");
            String adr = resultSet.getString("ADR");
            String rkc = resultSet.getString("RKC");
            String namep = resultSet.getString("NAMEP");
            String newnum = resultSet.getString("NEWNUM");
            String telefon = resultSet.getString("TELEF");
            String regn = resultSet.getString("REGN");
            String okpo = resultSet.getString("OKPO");
            Date dt_izm = resultSet.getDate("DT_IZM");
            String ksnp = resultSet.getString("KSNP");
            Date date_in = resultSet.getDate("DATE_IN");
            Date date_ch = resultSet.getDate("DATE_CH");

            bnkSeekList.add(new BnkSeek(real, pzn, uer, rgn, ind, tnp, nnp, adr, rkc, namep, newnum, telefon, regn, okpo, dt_izm, ksnp, date_in, date_ch));
        }

        return bnkSeekList;
    }

    //    PZN
    public List<ParticipantSettlement> getParticipantSettlements() throws SQLException {
        String sql = "SELECT * FROM PZN";

        List<ParticipantSettlement> participantSettlementList = new ArrayList<>();
        ResultSet resultSet = jdbcTemplate.executeQuery(sql);
        while (resultSet.next()) {
            String pzn = resultSet.getString("PZN");
            String imy = resultSet.getString("IMY");
            String name = resultSet.getString("NAME");

            participantSettlementList.add(new ParticipantSettlement(pzn, imy, name));
        }

        return participantSettlementList;
    }

    //    UER
    public List<ElectParticipant> getElectParticipants() throws SQLException {
        String sql = "SELECT * FROM UER";

        List<ElectParticipant> electParticipantList = new ArrayList<>();
        ResultSet resultSet = jdbcTemplate.executeQuery(sql);
        while (resultSet.next()) {
            String uer = resultSet.getString("UER");
            String name = resultSet.getString("UERNAME");

            electParticipantList.add(new ElectParticipant(uer, name));
        }

        return electParticipantList;
    }

    //    REG
    public List<Region> getRegions() throws SQLException {
        String sql = "SELECT * FROM REG";

        List<Region> regionList = new ArrayList<>();
        ResultSet resultSet = jdbcTemplate.executeQuery(sql);
        while (resultSet.next()) {
            String rgn = resultSet.getString("RGN");
            String name = resultSet.getString("NAME");

            regionList.add(new Region(rgn, name));
        }

        return regionList;
    }

    //    TNP
    public List<TypeLocality> getTypeLocality() throws SQLException {
        String sql = "SELECT * FROM TNP";

        List<TypeLocality> localityList = new ArrayList<>();
        ResultSet resultSet = jdbcTemplate.executeQuery(sql);
        while (resultSet.next()) {
            String tnp = resultSet.getString("TNP");
            String name = resultSet.getString("FULLNAME");

            localityList.add(new TypeLocality(tnp, name));
        }

        return localityList;
    }

}
