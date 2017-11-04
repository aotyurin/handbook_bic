package main.java.dao;

import main.java.bd.JdbcTemplate;
import main.java.bd.preparedParams.PreparedParamsSetter;
import main.java.bd.register.JdbcTemplateSqlite;
import main.java.dto.BnkSeekDto;
import main.java.model.BnkSeek;
import main.java.model.BnkSeekName;
import main.java.util.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BnkSeekDao {
    private final JdbcTemplate jdbcTemplate;

    public BnkSeekDao() {
        this.jdbcTemplate = new JdbcTemplateSqlite();
    }

    public void overload(List<BnkSeek> bnkSeekList) {
        String sqlClean__Bnk_Seek = "DELETE FROM Bnk_Seek;";
        jdbcTemplate.executeUpdate(sqlClean__Bnk_Seek);

        for (BnkSeek bnkSeek : bnkSeekList) {
            insert(bnkSeek);
        }
    }

    public List<BnkSeekName> getBnkSeekList() {
        String sql = "select\n" +
                "  real,\n" +
                "  Bnk_Seek.pzn,\n" +
                "  Participant_Settlement.name AS pzn_name,\n" +
                "  Bnk_Seek.uer,\n" +
                "  Elect_Participant.name AS uer_name,\n" +
                "  Bnk_Seek.rgn,\n" +
                "  Region.name AS rgn_name,\n" +
                "  ind,\n" +
                "  Bnk_Seek.tnp,\n" +
                "  Type_Locality.tnp AS tnp_name,\n" +
                "  nnp,\n" +
                "  adr,\n" +
                "  rkc,\n" +
                "  namep,\n" +
                "  newnum,\n" +
                "  telefon,\n" +
                "  regn,\n" +
                "  okpo,\n" +
                "  dt_izm,\n" +
                "  ksnp,\n" +
                "  date_in,\n" +
                "  date_ch,  \n" +
                "  imy\n" +
                "from Bnk_Seek\n" +
                "LEFT JOIN Participant_Settlement ON Bnk_Seek.pzn=Participant_Settlement.pzn\n" +
                "LEFT JOIN Elect_Participant ON Bnk_Seek.uer=Elect_Participant.uer\n" +
                "LEFT JOIN Region ON Bnk_Seek.rgn=Region.rgn\n" +
                "LEFT JOIN Type_Locality ON Bnk_Seek.tnp=Type_Locality.tnp; ";

        List<BnkSeekName> bnkSeekNameList = new ArrayList<>();
        ResultSet resultSet = jdbcTemplate.executeQuery(sql);
        try {
            while (resultSet.next()) {
                String real = resultSet.getString("real");
                String pzn = resultSet.getString("pzn");
                String pznName = resultSet.getString("pzn_name");
                String uer = resultSet.getString("uer");
                String uerName = resultSet.getString("uer_name");
                String rgn = resultSet.getString("rgn");
                String rgnName = resultSet.getString("rgn_name");
                String ind = resultSet.getString("ind");
                String tnp = resultSet.getString("tnp");
                String tnpName = resultSet.getString("tnp_name");
                String nnp = resultSet.getString("nnp");
                String adr = resultSet.getString("adr");
                String rkc = resultSet.getString("rkc");
                String namep = resultSet.getString("namep");
                String newnum = resultSet.getString("newnum");
                String telefon = resultSet.getString("telefon");
                String regn = resultSet.getString("regn");
                String okpo = resultSet.getString("okpo");
                Date dt_izm = DateUtil.parse(resultSet.getString("dt_izm"));
                String ksnp = resultSet.getString("ksnp");
                Date date_in = DateUtil.parse(resultSet.getString("date_in"));
                Date date_ch = DateUtil.parse(resultSet.getString("date_ch"));

                bnkSeekNameList.add(new BnkSeekName(real, pzn, uer, rgn, ind, tnp, nnp, adr, rkc, namep, newnum, telefon,
                        regn, okpo, dt_izm, ksnp, date_in, date_ch, pznName, uerName, rgnName, tnpName));
            }
            return bnkSeekNameList;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public void insert(BnkSeek bnkSeek) {
        String sqlInsert__Bnk_Seek = "INSERT OR REPLACE INTO Bnk_Seek VALUES (:real, :pzn, :uer, :rgn, :ind, :tnp, :nnp, :adr, :rkc, :namep, " +
                " :newnum, :telefon, :regn, :okpo, :dt_izm, :ksnp, :date_in, :date_ch);";
        PreparedParamsSetter pps = new PreparedParamsSetter();
        pps.setValues("real", bnkSeek.getReal());
        pps.setValues("pzn", bnkSeek.getPzn());
        pps.setValues("uer", bnkSeek.getUer());
        pps.setValues("rgn", bnkSeek.getRgn());
        pps.setValues("ind", bnkSeek.getInd());
        pps.setValues("tnp", bnkSeek.getTnp());
        pps.setValues("nnp", bnkSeek.getNnp());
        pps.setValues("adr", bnkSeek.getAdr());
        pps.setValues("rkc", bnkSeek.getRkc());
        pps.setValues("namep", bnkSeek.getNamep());
        pps.setValues("newnum", bnkSeek.getNewnum());
        pps.setValues("telefon", bnkSeek.getTelefon());
        pps.setValues("regn", bnkSeek.getRegn());
        pps.setValues("okpo", bnkSeek.getOkpo());
        pps.setValues("dt_izm", DateUtil.format(bnkSeek.getDt_izm()));
        pps.setValues("ksnp", bnkSeek.getKsnp());
        pps.setValues("date_in", DateUtil.format(bnkSeek.getDate_in()));
        pps.setValues("date_ch", DateUtil.format(bnkSeek.getDate_ch()));

        jdbcTemplate.executeUpdate(sqlInsert__Bnk_Seek, pps);
    }

    public void deleteById(String newnum) {
        String sqlDel__Bnk_Seek = "DELETE FROM Bnk_Seek WHERE newnum=:newnum;";
        PreparedParamsSetter pps = new PreparedParamsSetter();
        pps.setValues("newnum", newnum);
        jdbcTemplate.executeUpdate(sqlDel__Bnk_Seek, pps);
    }

}
