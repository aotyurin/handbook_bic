package main.java.service;


import main.java.dao.TypeLocalityDao;
import main.java.dto.TypeLocalityDto;
import main.java.model.TypeLocality;

import java.util.ArrayList;
import java.util.List;

public class TypeLocalityService {
    private TypeLocalityDao typeLocalityDao;

    public TypeLocalityService() {
        this.typeLocalityDao = new TypeLocalityDao();
    }

    public List<TypeLocalityDto> getTypeLocalityList() {
        List<TypeLocalityDto> typeLocalityDtoList = new ArrayList<>();
        List<TypeLocality> typeLocalityList = typeLocalityDao.getTypeLocalityList();
        for (TypeLocality typeLocality : typeLocalityList) {
            typeLocalityDtoList.add(new TypeLocalityDto(typeLocality.getTnp(), typeLocality.getName()));
        }

        return typeLocalityDtoList;
    }
}
