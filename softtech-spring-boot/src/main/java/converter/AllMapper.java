package converter;

import dao.DistrictDao;
import dto.*;
import entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AllMapper {
    AllMapper INSTANCE = Mappers.getMapper(AllMapper.class);

    CountryEntity convertToCountryEntity(CountrySaveRequestDto countrySaveRequestDto);
    CountryDto convertToCountryDto(CountryEntity countryEntity);

    CityEntity convertToCityEntity(CitySaveRequestDto citySaveRequestDto);
    CityDto convertToCityDto(CityEntity cityEntity);

    DistrictEntity convertToDistrictEntity(DistrictSaveRequestDto districtSaveRequestDto);
    DistrictDto convertToDistrictDto(DistrictEntity districtEntity);

    NeighborhoodEntity convertToNeighborhoodEntity(NeighborhoodSaveRequestDto neighborhoodSaveRequestDto);
    NeighborhoodDto convertToNeighborhoodDto(NeighborhoodEntity neighborhoodEntity);
    NeighborhoodEntity convertNeighborhoodDtoToNeighborhoodEntity(NeighborhoodDto neighborhoodDto);

    StreetEntity convertToStreetEntity(StreetSaveRequestDto streetSaveRequestDto);
    StreetDto convertToStreetDto(StreetEntity streetEntity);
    StreetEntity convertStreetDtoToStreetEntity(StreetDto streetDto);

    AddressEntity convertToAddressEntity(AddressSaveRequestDto addressSaveRequestDto);
    AddressDto convertToAddressDto(AddressEntity addressEntity);
}
