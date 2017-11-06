package main.java.service;


import main.java.dao.ParticipantSettlementDao;
import main.java.dto.ParticipantSettlementDto;
import main.java.model.ParticipantSettlement;

import java.util.ArrayList;
import java.util.List;

public class ParticipantSettlementService {
    private ParticipantSettlementDao participantSettlementDao;

    public ParticipantSettlementService() {
        this.participantSettlementDao = new ParticipantSettlementDao();
    }

    public List<ParticipantSettlementDto> getParticipantSettlementList() {
        List<ParticipantSettlementDto> participantSettlementDtoList = new ArrayList<>();

        List<ParticipantSettlement> participantSettlementList = participantSettlementDao.getParticipantSettlementList();
        for (ParticipantSettlement participantSettlement : participantSettlementList) {
            participantSettlementDtoList.add(new ParticipantSettlementDto(participantSettlement.getPzn(), participantSettlement.getName()));
        }

        return participantSettlementDtoList;
    }
}
