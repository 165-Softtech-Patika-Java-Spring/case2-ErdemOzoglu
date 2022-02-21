package service.entityService;

import converter.AllMapper;
import dao.CountryDao;
import dto.CountryDto;
import dto.CountrySaveRequestDto;
import entity.CountryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryEntityService {

    private final CountryDao countryDao;

    public CountryDto saveCountryEntity(CountrySaveRequestDto countrySaveRequestDto){

        CountryEntity countryEntity = AllMapper.INSTANCE.convertToCountryEntity(countrySaveRequestDto);

        countryEntity = countryDao.save(countryEntity);

        CountryDto countryDto = AllMapper.INSTANCE.convertToCountryDto(countryEntity);

        return countryDto;
    }



    public List<CountryEntity> getByCountryCode(String countryCode){

        List<CountryEntity> allCountryEntities =  countryDao.findAll();
        List<CountryEntity> countryCodeFound = null;
        for(CountryEntity ce : allCountryEntities){
            String searchedCountryCode = ce.getCountryCode();
            if( countryCode.equals(searchedCountryCode) ){
                countryCodeFound.add(ce);
            }
        }

        return countryCodeFound;
    }



}
