package main.java.dao;

import main.java.bd.JdbcTemplate;
import main.java.bd.preparedParams.PreparedParamsSetter;
import main.java.bd.register.JdbcTemplateSqlite;
import main.java.model.Region;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<Region> getRegionList() {
        String sql = "SELECT rgn, name FROM Region;";

        List<Region> regionList = new ArrayList<>();
        ResultSet resultSet = jdbcTemplate.executeQuery(sql);
        try {
            while (resultSet.next()) {
                String rgn = resultSet.getString("rgn");
                String name = resultSet.getString("name");

                regionList.add(new Region(rgn, name));
            }

            return regionList;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

}
