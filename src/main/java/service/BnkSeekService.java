package main.java.service;

import main.java.dao.BnkSeekDao;
import main.java.dto.BnkSeekDto;
import main.java.model.BnkSeek;
import main.java.model.BnkSeekName;

import java.util.ArrayList;
import java.util.List;

public class BnkSeekService {
    private BnkSeekDao bnkSeekDao;

    public BnkSeekService() {
        this.bnkSeekDao = new BnkSeekDao();
    }

    public List<BnkSeekDto> getBnkSeekList() {
        List<BnkSeekDto> bnkSeekDtoList = new ArrayList<>();

        List<BnkSeekName> bnkSeekNameList = bnkSeekDao.getBnkSeekList();
        for (BnkSeekName bnkSeekName : bnkSeekNameList) {
            bnkSeekDtoList.add(new BnkSeekDto(bnkSeekName.getReal(), bnkSeekName.getPznName(), bnkSeekName.getUerName(), bnkSeekName.getRgnName(),
                    bnkSeekName.getInd(), bnkSeekName.getTnpName(), bnkSeekName.getNnp(), bnkSeekName.getAdr(), bnkSeekName.getRkc(),
                    bnkSeekName.getNamep(), bnkSeekName.getNewnum(), bnkSeekName.getTelefon(), bnkSeekName.getRegn(), bnkSeekName.getOkpo(),
                    bnkSeekName.getDt_izm(), bnkSeekName.getKsnp(), bnkSeekName.getDate_in(), bnkSeekName.getDate_ch()));
        }

        return bnkSeekDtoList;
    }

    public void deleteById(String newnum) {
        bnkSeekDao.deleteById(newnum);
    }

    public void edit(BnkSeekDto bnkSeekDto) {
        bnkSeekDao.insert(new BnkSeekName(bnkSeekDto.getReal(), bnkSeekDto.getPznName(), bnkSeekDto.getUerName(), bnkSeekDto.getRgnName(),
                bnkSeekDto.getInd(), bnkSeekDto.getTnpName(), bnkSeekDto.getNnp(), bnkSeekDto.getAdr(), bnkSeekDto.getRkc(),
                bnkSeekDto.namepProperty().get(), bnkSeekDto.newnumProperty().get(), bnkSeekDto.getTelefon(), bnkSeekDto.getRegn(), bnkSeekDto.getOkpo(),
                bnkSeekDto.getDt_izm(), bnkSeekDto.getKsnp(), bnkSeekDto.getDate_in(), bnkSeekDto.getDate_ch(),
                bnkSeekDto.getPznName(), bnkSeekDto.getUerName(), bnkSeekDto.getRgnName(), bnkSeekDto.getTnpName()));
    }
}
