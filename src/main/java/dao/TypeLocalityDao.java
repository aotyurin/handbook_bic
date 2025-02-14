package main.java.dao;

import main.java.bd.JdbcTemplate;
import main.java.bd.preparedParams.PreparedParamsSetter;
import main.java.bd.register.JdbcTemplateSqlite;
import main.java.model.TypeLocality;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TypeLocalityDao {
    private final JdbcTemplate jdbcTemplate;

    public TypeLocalityDao() {
        this.jdbcTemplate = new JdbcTemplateSqlite();
    }

    public void overload(List<TypeLocality> typeLocalityList) {
        String sqlClean__Type_Locality = "DELETE FROM Type_Locality;";
        jdbcTemplate.executeUpdate(sqlClean__Type_Locality);

        String sqlInsert__Type_Locality = "INSERT INTO Type_Locality VALUES (:tnp, :name );";
        for (TypeLocality typeLocality: typeLocalityList) {
            PreparedParamsSetter pps = new PreparedParamsSetter();
            pps.setValues("tnp", typeLocality.getTnp());
            pps.setValues("name", typeLocality.getName());

            jdbcTemplate.executeUpdate(sqlInsert__Type_Locality, pps);
        }

    }

    public List<TypeLocality> getTypeLocalityList() {
        String sql = "SELECT tnp, name FROM Type_Locality;";

        List<TypeLocality> typeLocalityList = new ArrayList<>();
        ResultSet resultSet = jdbcTemplate.executeQuery(sql);
        try {
            while (resultSet.next()) {
                String tnp = resultSet.getString("tnp");
                String name = resultSet.getString("name");

                typeLocalityList.add(new TypeLocality(tnp, name));
            }

            return typeLocalityList;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

}
