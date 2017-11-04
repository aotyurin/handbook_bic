package main.java.service;


import main.java.dao.ElectParticipantDao;
import main.java.dto.ElectParticipantDto;
import main.java.model.ElectParticipant;

import java.util.ArrayList;
import java.util.List;

public class ElectParticipantService {
    private ElectParticipantDao electParticipantDao;

    public ElectParticipantService() {
        this.electParticipantDao = new ElectParticipantDao();
    }

    public List<ElectParticipantDto> getElectParticipantList() {
        List<ElectParticipantDto> electParticipantDtoList = new ArrayList<>();
        List<ElectParticipant> participantList = electParticipantDao.getElectParticipantList();
        for (ElectParticipant participant : participantList) {
            electParticipantDtoList.add(new ElectParticipantDto(participant.getUer(), participant.getName()));
        }

        return electParticipantDtoList;
    }


}
