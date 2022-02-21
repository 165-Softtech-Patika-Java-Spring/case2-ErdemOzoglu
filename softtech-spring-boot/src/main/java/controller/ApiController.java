package controller;


import dto.*;
import entity.AddressEntity;
import entity.CountryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.entityService.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/address" )
@RequiredArgsConstructor
public class ApiController {

    private final CountryEntityService countryEntityService;
    private final CityEntityService cityEntityService;
    private final DistrictEntityService districtEntityService;
    private final NeighborhoodEntityService neighborhoodEntityService;
    private final StreetEntityService streetEntityService;
    private final AddressEntityService addressEntityService;

    @PostMapping("/saveCountry")
    public ResponseEntity saveCountry(@RequestBody CountrySaveRequestDto countrySaveRequestDto){


        CountryDto countryDto = countryEntityService.saveCountryEntity(countrySaveRequestDto);

        return ResponseEntity.ok(countryDto);
    }

    @PostMapping("/saveCity")
    public ResponseEntity saveCity(@RequestBody CitySaveRequestDto citySaveRequestDto){

       CityDto cityDto = cityEntityService.saveCityEntity(citySaveRequestDto);

        return ResponseEntity.ok(cityDto);
    }

    @PostMapping("/saveDistrict")
    public ResponseEntity saveDistrict(@RequestBody DistrictSaveRequestDto districtSaveRequestDto){

        DistrictDto districtDto = districtEntityService.saveDistrictEntity(districtSaveRequestDto);

        return ResponseEntity.ok(districtDto);
    }

    @PostMapping("/saveNeighborhood")
    public ResponseEntity saveNeighborhood(@RequestBody NeighborhoodSaveRequestDto neighborhoodSaveRequestDto){

        NeighborhoodDto neighborhoodDto = neighborhoodEntityService.saveNeighborhoodEntity(neighborhoodSaveRequestDto);

        return ResponseEntity.ok(neighborhoodDto);
    }

    @PostMapping("/saveStreet")
    public ResponseEntity saveStreet(@RequestBody StreetSaveRequestDto streetSaveRequestDto){

        StreetDto streetDto = streetEntityService.saveStreetEntity(streetSaveRequestDto);

        return ResponseEntity.ok(streetDto);
    }

    @PostMapping("/saveAddress")
    public ResponseEntity saveAddress(@RequestBody AddressSaveRequestDto addressSaveRequestDto){

        AddressDto addressDto = addressEntityService.saveAddressEntity(addressSaveRequestDto);

        return ResponseEntity.ok(addressDto);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public void deleteAddress(@PathVariable Long id){

        addressEntityService.deleteAddress(id);
    }

    @GetMapping("/findByIdAddress/{id}")
    public ResponseEntity findByIdAddress(@PathVariable Long id){

        Optional<AddressEntity> optionalAddress = addressEntityService.findById(id);

        return ResponseEntity.ok(optionalAddress);
    }
    @GetMapping("/getByCountryCode/{countryCode}")
    public ResponseEntity getByCountryCode(@PathVariable String countryCode){

        List<CountryEntity> countriesFilteredByCountryCode = countryEntityService.getByCountryCode(countryCode);

        return ResponseEntity.ok(countriesFilteredByCountryCode);
    }

    @GetMapping("/getByCityPlateNumber/{cityPlateNumber}")
    public ResponseEntity getByCityPlateNumber(@PathVariable int cityPlateNumber){

        CityDto cityDto = cityEntityService.getByCityPlateNumber(cityPlateNumber);

        return ResponseEntity.ok(cityDto);
    }

    @GetMapping("/getByCityPlateNumber/{cityId}")
    public ResponseEntity getByDistricts(@PathVariable int cityId){

        List<DistrictDto> districtDtos = districtEntityService.getByDistrictsOfTheCity(cityId);

        return ResponseEntity.ok(districtDtos);
    }

    @GetMapping("/getByNeighborhoods/{districtId}")
    public ResponseEntity getByNeighborhoods(@PathVariable int districtId){

        List<NeighborhoodDto> neighborhoodDtos = neighborhoodEntityService.getByNeighborhoodsOfTheDistrict(districtId);

        return ResponseEntity.ok(neighborhoodDtos);
    }

    @GetMapping("/getByStreets/{neighborhoodId}")
    public ResponseEntity getByStreets(@PathVariable int neighborhoodId){

        List<StreetDto> streetDtos = streetEntityService.getByStreetsOfTheNeighborhood(neighborhoodId);

        return ResponseEntity.ok(streetDtos);
    }

    @PutMapping("/updateStreetName")
    public ResponseEntity updateStreetName(@RequestBody StreetDto streetDto){

        StreetDto streetDto1 = streetEntityService.updateStreetName(streetDto);

        return ResponseEntity.ok(streetDto1);
    }
    @PutMapping("/updateStreetName")
    public ResponseEntity updateNeighborhoodName(@RequestBody NeighborhoodDto neighborhoodDto){

        NeighborhoodDto neighborhoodDto1 = neighborhoodEntityService.updateNeighborhoodName(neighborhoodDto);

        return ResponseEntity.ok(neighborhoodDto1);
    }

}
