package main.java.service;


import main.java.dao.RegionDao;
import main.java.dto.RegionDto;
import main.java.model.Region;

import java.util.ArrayList;
import java.util.List;

public class RegionService {
    private RegionDao regionDao;

    public RegionService() {
        this.regionDao = new RegionDao();
    }

    public List<RegionDto> getRegionList() {
        List<RegionDto> regionDtoList = new ArrayList<>();
        List<Region> regionList = regionDao.getRegionList();
        for (Region region : regionList) {
            regionDtoList.add(new RegionDto(region.getRgn(), region.getName()));
        }

        return regionDtoList;
    }


}
