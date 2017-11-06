package main.java.dao;

import main.java.bd.JdbcTemplate;
import main.java.bd.preparedParams.PreparedParamsSetter;
import main.java.bd.register.JdbcTemplateSqlite;
import main.java.model.ParticipantSettlement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<ParticipantSettlement> getParticipantSettlementList() {
        String sql = "SELECT pzn, imy, name FROM Participant_Settlement;";

        List<ParticipantSettlement> settlementList = new ArrayList<>();
        ResultSet resultSet = jdbcTemplate.executeQuery(sql);
        try {
            while (resultSet.next()) {
                String rgn = resultSet.getString("pzn");
                String imy = resultSet.getString("imy");
                String name = resultSet.getString("name");

                settlementList.add(new ParticipantSettlement(rgn, imy, name));
            }

            return settlementList;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

}
