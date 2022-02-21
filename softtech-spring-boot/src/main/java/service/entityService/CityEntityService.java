package service.entityService;


import converter.AllMapper;
import dao.CityDao;
import dto.CityDto;
import dto.CitySaveRequestDto;
import entity.CityEntity;
import entity.CountryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityEntityService {

    private final CityDao cityDao;

    public CityDto saveCityEntity(CitySaveRequestDto citySaveRequestDto){

        CityEntity cityEntity = AllMapper.INSTANCE.convertToCityEntity(citySaveRequestDto);

        cityEntity = cityDao.save(cityEntity);

        CityDto cityDto = AllMapper.INSTANCE.convertToCityDto(cityEntity);

        return cityDto;
    }

    public CityDto getByCityPlateNumber(int cityPlateNumber){
        List<CityEntity> allCityEntities =  cityDao.findAll();
        CityEntity cityEntityFound = null;

        for(CityEntity ce : allCityEntities){
            int searchedCityPlateNumber = ce.getCityPlateNumber();
            if( cityPlateNumber == searchedCityPlateNumber ){
                cityEntityFound = ce;
            }

        }
        CityDto cityDto = AllMapper.INSTANCE.convertToCityDto(cityEntityFound);
        return cityDto;
    }

}
