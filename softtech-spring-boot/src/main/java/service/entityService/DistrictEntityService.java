package service.entityService;

import converter.AllMapper;
import dao.DistrictDao;
import dto.CityDto;
import dto.DistrictDto;
import dto.DistrictSaveRequestDto;
import entity.CityEntity;
import entity.DistrictEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictEntityService {

    private final DistrictDao districtDao;

    public DistrictDto saveDistrictEntity(DistrictSaveRequestDto districtSaveRequestDto){

        DistrictEntity districtEntity= AllMapper.INSTANCE.convertToDistrictEntity(districtSaveRequestDto);

        districtEntity = districtDao.save(districtEntity);

        DistrictDto districtDto = AllMapper.INSTANCE.convertToDistrictDto(districtEntity);

        return districtDto;
    }

    public List<DistrictDto> getByDistrictsOfTheCity(int cityId){

        List<DistrictEntity> allDistrictEntities = districtDao.findAll();
        List<DistrictDto> districtsFound = null;

        for(DistrictEntity de : allDistrictEntities){
            int searchedCityId = de.getCityId();
            if(cityId == searchedCityId){
                districtsFound.add(AllMapper.INSTANCE.convertToDistrictDto(de));
            }
        }
        return districtsFound;
    }

}
