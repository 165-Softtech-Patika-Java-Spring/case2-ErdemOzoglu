package dto;

import lombok.Data;

@Data
public class CitySaveRequestDto {

    private String CityName;
    private int CityPlateNumber;
    private int CityId;
    private int CountryId;
}
