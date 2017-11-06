package main.java.dao;

import main.java.bd.JdbcTemplate;
import main.java.bd.preparedParams.PreparedParamsSetter;
import main.java.bd.register.JdbcTemplateSqlite;
import main.java.model.ElectParticipant;

import java.util.List;

public class ElectParticipantDao {
    private final JdbcTemplate jdbcTemplate;

    public ElectParticipantDao() {
        this.jdbcTemplate = new JdbcTemplateSqlite();
    }

    public void overload(List<ElectParticipant> electParticipantList) {
        String sqlClean__Elect_Participant = "DELETE FROM Elect_Participant;";
        jdbcTemplate.executeUpdate(sqlClean__Elect_Participant);

        String sqlInsert__Elect_Participant = "INSERT INTO Elect_Participant VALUES (:pzn, :name );";
        for (ElectParticipant electParticipant : electParticipantList) {
            PreparedParamsSetter pps = new PreparedParamsSetter();
            pps.setValues("pzn", electParticipant.getPzn());
            pps.setValues("name", electParticipant.getName());

            jdbcTemplate.executeUpdate(sqlInsert__Elect_Participant, pps);
        }
    }
}
