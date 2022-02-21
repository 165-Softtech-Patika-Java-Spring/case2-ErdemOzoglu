package service.entityService;

import converter.AllMapper;
import dao.NeighborhoodDao;
import dto.DistrictDto;
import dto.NeighborhoodDto;
import dto.NeighborhoodSaveRequestDto;
import dto.StreetDto;
import entity.DistrictEntity;
import entity.NeighborhoodEntity;
import entity.StreetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NeighborhoodEntityService {

    private final NeighborhoodDao neighborhoodDao;

    public NeighborhoodDto saveNeighborhoodEntity(NeighborhoodSaveRequestDto neighborhoodSaveRequestDto){

        NeighborhoodEntity neighborhoodEntity= AllMapper.INSTANCE.convertToNeighborhoodEntity(neighborhoodSaveRequestDto);

        neighborhoodEntity = neighborhoodDao.save(neighborhoodEntity);

        NeighborhoodDto neighborhoodDto = AllMapper.INSTANCE.convertToNeighborhoodDto(neighborhoodEntity);

        return neighborhoodDto;
    }

    public List<NeighborhoodDto> getByNeighborhoodsOfTheDistrict(int districtId){

        List<NeighborhoodEntity> allNeighborhoodEntities = neighborhoodDao.findAll();
        List<NeighborhoodDto> neighborhoodsFound = null;

        for(NeighborhoodEntity ne : allNeighborhoodEntities){
            int searchedDistrictId = ne.getDistrictId();
            if(districtId == searchedDistrictId){
                neighborhoodsFound.add(AllMapper.INSTANCE.convertToNeighborhoodDto(ne));
            }
        }
        return neighborhoodsFound;
    }

    public NeighborhoodDto updateNeighborhoodName(NeighborhoodDto newNeighborhoodEntity){

        NeighborhoodEntity neighborhoodEntity = AllMapper.INSTANCE.convertNeighborhoodDtoToNeighborhoodEntity(newNeighborhoodEntity);

        neighborhoodEntity = neighborhoodDao.save(neighborhoodEntity);

        NeighborhoodDto neighborhoodDto = AllMapper.INSTANCE.convertToNeighborhoodDto(neighborhoodEntity);

        return neighborhoodDto;
    }




}
