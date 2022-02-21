package service.entityService;

import converter.AllMapper;
import dao.StreetDao;
import dto.*;
import entity.StreetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StreetEntityService {

    private final StreetDao streetDao;

    public StreetDto saveStreetEntity(StreetSaveRequestDto streetSaveRequestDto){

        StreetEntity streetEntity = AllMapper.INSTANCE.convertToStreetEntity(streetSaveRequestDto);

        streetEntity = streetDao.save(streetEntity);

        StreetDto streetDto = AllMapper.INSTANCE.convertToStreetDto(streetEntity);

        return streetDto;
    }

    public List<StreetDto> getByStreetsOfTheNeighborhood(int neighborhoodId){

        List<StreetEntity> allStreetEntities = streetDao.findAll();
        List<StreetDto> streetsFound = null;

        for(StreetEntity se : allStreetEntities){
            int searchedNeighborhoodId = se.getNeighborhoodId();
            if(neighborhoodId == searchedNeighborhoodId){
                streetsFound.add(AllMapper.INSTANCE.convertToStreetDto(se));
            }
        }
        return streetsFound;
    }

    public StreetDto updateStreetName(StreetDto newStreetEntity){

        StreetEntity streetEntity = AllMapper.INSTANCE.convertStreetDtoToStreetEntity(newStreetEntity);

        streetEntity = streetDao.save(streetEntity);

        StreetDto streetDto = AllMapper.INSTANCE.convertToStreetDto(streetEntity);

        return streetDto;
    }


}
