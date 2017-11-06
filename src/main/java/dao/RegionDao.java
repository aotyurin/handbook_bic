package main.java.dao;

import main.java.bd.JdbcTemplate;
import main.java.bd.preparedParams.PreparedParamsSetter;
import main.java.bd.register.JdbcTemplateSqlite;
import main.java.model.Region;

import java.util.List;

public class RegionDao {
    private final JdbcTemplate jdbcTemplate;

    public RegionDao() {
        this.jdbcTemplate = new JdbcTemplateSqlite();
    }

    public void overload(List<Region> regionList) {
        String sqlClean__Region = "DELETE FROM Region;";
        jdbcTemplate.executeUpdate(sqlClean__Region);

        String sqlInsert__Region = "INSERT INTO Region VALUES (:rgn, :name );";
        for (Region region : regionList) {
            PreparedParamsSetter pps = new PreparedParamsSetter();
            pps.setValues("rgn", region.getRgn());
            pps.setValues("name", region.getName());

            jdbcTemplate.executeUpdate(sqlInsert__Region, pps);
        }
    }
}
