package main.java.dao;

import main.java.bd.JdbcTemplate;
import main.java.bd.preparedParams.PreparedParamsSetter;
import main.java.bd.register.JdbcTemplateSqlite;
import main.java.model.BnkSeek;

import java.util.List;

public class BnkSeekDao {
    private final JdbcTemplate jdbcTemplate;

    public BnkSeekDao() {
        this.jdbcTemplate = new JdbcTemplateSqlite();
    }

    public void overload(List<BnkSeek> bnkSeekList) {
        String sqlClean__Bnk_Seek = "DELETE FROM Bnk_Seek;";
        jdbcTemplate.executeUpdate(sqlClean__Bnk_Seek);

        String sqlInsert__Bnk_Seek = "INSERT INTO Bnk_Seek VALUES (:real, :pzn, :uer, :rgn, :ind, :tnp, :nnp, :adr, :rkc, :namep, " +
                " :newnum, :telefon, :regn, :okpo, :dt_izm, :ksnp, :date_in, :date_ch);";
        for (BnkSeek bnkSeek : bnkSeekList) {
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
            pps.setValues("dt_izm", bnkSeek.getDt_izm());
            pps.setValues("ksnp", bnkSeek.getKsnp());
            pps.setValues("date_in", bnkSeek.getDate_in());
            pps.setValues("date_ch", bnkSeek.getDate_ch());

            jdbcTemplate.executeUpdate(sqlInsert__Bnk_Seek, pps);
        }

    }
}
