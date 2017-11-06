package main.java.dao;

import main.java.bd.JdbcTemplate;
import main.java.bd.preparedParams.PreparedParamsSetter;
import main.java.bd.register.JdbcTemplateSqlite;
import main.java.model.ParticipantSettlement;

import java.util.List;

public class ParticipantSettlementDao {
    private final JdbcTemplate jdbcTemplate;

    public ParticipantSettlementDao() {
        this.jdbcTemplate = new JdbcTemplateSqlite();
    }

    public void overload(List<ParticipantSettlement> participantSettlementList) {
        String sqlClean__Participant_Settlement = "DELETE FROM Participant_Settlement;";
        jdbcTemplate.executeUpdate(sqlClean__Participant_Settlement);

        String sqlInsert__Participant_Settlement = "INSERT INTO Participant_Settlement VALUES (:pzn, :imy, :name );";
        for (ParticipantSettlement participantSettlement : participantSettlementList) {
            PreparedParamsSetter pps = new PreparedParamsSetter();
            pps.setValues("pzn", participantSettlement.getPzn());
            pps.setValues("imy", participantSettlement.getImy());
            pps.setValues("name", participantSettlement.getName());

            jdbcTemplate.executeUpdate(sqlInsert__Participant_Settlement, pps);
        }
    }
}
