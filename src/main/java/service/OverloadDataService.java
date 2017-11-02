package main.java.service;

import main.java.dao.OdbcDirectoriesDao;
import main.java.model.*;

import java.sql.SQLException;
import java.util.List;

public class OverloadDataService {
    OdbcDirectoriesDao odbcDirectoriesDao = new OdbcDirectoriesDao();

    public void overloadDataFromDbf() throws SQLException {
        List<BnkSeek> bnkSeekList = odbcDirectoriesDao.getBnkSeek();
        System.out.println(bnkSeekList.size());


        List<ParticipantSettlement> participantSettlementList = odbcDirectoriesDao.getParticipantSettlements();
        System.out.println(participantSettlementList.size());
        List<ElectParticipant> electParticipantList = odbcDirectoriesDao.getElectParticipants();
        System.out.println(electParticipantList.size());
        List<Region> regionList = odbcDirectoriesDao.getRegions();
        System.out.println(regionList.size());
        List<TypeLocality> typeLocalityList = odbcDirectoriesDao.getTypeLocality();
        System.out.println(typeLocalityList.size());
    }
}
