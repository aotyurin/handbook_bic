package main.java.service;

import main.java.dao.BnkSeekDao;
import main.java.dao.ElectParticipantDao;
import main.java.dao.InitBdDao;
import main.java.dao.OdbcDirectoriesDao;
import main.java.dao.ParticipantSettlementDao;
import main.java.dao.RegionDao;
import main.java.dao.TypeLocalityDao;
import main.java.model.BnkSeek;
import main.java.model.ElectParticipant;
import main.java.model.ParticipantSettlement;
import main.java.model.Region;
import main.java.model.TypeLocality;

import java.sql.SQLException;
import java.util.List;


public class OverloadDataService {
    private OdbcDirectoriesDao odbcDirectoriesDao;
    private BnkSeekDao bnkSeekDao;
    private TypeLocalityDao typeLocalityDao;
    private ParticipantSettlementDao participantSettlementDao;
    private ElectParticipantDao electParticipantDao;
    private RegionDao regionDao;


    public OverloadDataService() {
        this.odbcDirectoriesDao = new OdbcDirectoriesDao();
        this.bnkSeekDao = new BnkSeekDao();
        this.typeLocalityDao = new TypeLocalityDao();
        this.participantSettlementDao = new ParticipantSettlementDao();
        this.electParticipantDao = new ElectParticipantDao();
        this.regionDao = new RegionDao();
    }


    public void overloadDataFromDbf() throws SQLException {
        List<TypeLocality> typeLocalityList = odbcDirectoriesDao.getTypeLocality();
        typeLocalityDao.overload(typeLocalityList);

        List<ParticipantSettlement> participantSettlementList = odbcDirectoriesDao.getParticipantSettlements();
        participantSettlementDao.overload(participantSettlementList);

        List<ElectParticipant> electParticipantList = odbcDirectoriesDao.getElectParticipants();
        electParticipantDao.overload(electParticipantList);

        List<Region> regionList = odbcDirectoriesDao.getRegions();
        regionDao.overload(regionList);

        List<BnkSeek> bnkSeekList = odbcDirectoriesDao.getBnkSeek();
        bnkSeekDao.overload(bnkSeekList);
    }


}
