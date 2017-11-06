package main.java.dao;

import main.java.bd.JdbcTemplate;
import main.java.bd.preparedParams.PreparedParamsSetter;
import main.java.bd.register.JdbcTemplateSqlite;
import main.java.model.TypeLocality;

import java.util.List;

public class TypeLocalityDao {
    private final JdbcTemplate jdbcTemplate;

    public TypeLocalityDao() {
        this.jdbcTemplate = new JdbcTemplateSqlite();
    }

    public void overload(List<TypeLocality> typeLocalityList) {
        String sqlClean__Type_Locality = "DELETE FROM Type_Locality;";
        jdbcTemplate.executeUpdate(sqlClean__Type_Locality);

        String sqlInsert__Type_Locality = "INSERT INTO Type_Locality VALUES (:rgn, :name );";
        for (TypeLocality typeLocality: typeLocalityList) {
            PreparedParamsSetter pps = new PreparedParamsSetter();
            pps.setValues("rgn", typeLocality.getRgn());
            pps.setValues("name", typeLocality.getName());

            jdbcTemplate.executeUpdate(sqlInsert__Type_Locality, pps);
        }

    }
}
