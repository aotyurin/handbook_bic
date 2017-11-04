package main.java.dao;

import main.java.bd.JdbcTemplate;
import main.java.bd.preparedParams.PreparedParamsSetter;
import main.java.bd.register.JdbcTemplateSqlite;
import main.java.dto.ElectParticipantDto;
import main.java.model.ElectParticipant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElectParticipantDao {
    private final JdbcTemplate jdbcTemplate;

    public ElectParticipantDao() {
        this.jdbcTemplate = new JdbcTemplateSqlite();
    }

    public void overload(List<ElectParticipant> electParticipantList) {
        String sqlClean__Elect_Participant = "DELETE FROM Elect_Participant;";
        jdbcTemplate.executeUpdate(sqlClean__Elect_Participant);

        String sqlInsert__Elect_Participant = "INSERT INTO Elect_Participant VALUES (:uer, :name );";
        for (ElectParticipant electParticipant : electParticipantList) {
            PreparedParamsSetter pps = new PreparedParamsSetter();
            pps.setValues("uer", electParticipant.getUer());
            pps.setValues("name", electParticipant.getName());

            jdbcTemplate.executeUpdate(sqlInsert__Elect_Participant, pps);
        }

    }

    public List<ElectParticipant> getElectParticipantList() {
        String sql = "SELECT uer, name FROM Elect_Participant;";

        List<ElectParticipant> electParticipantList = new ArrayList<>();
        ResultSet resultSet = jdbcTemplate.executeQuery(sql);
        try {
            while (resultSet.next()) {
                String uer = resultSet.getString("uer");
                String name = resultSet.getString("name");

                electParticipantList.add(new ElectParticipant(uer, name));
            }

            return electParticipantList;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

}
