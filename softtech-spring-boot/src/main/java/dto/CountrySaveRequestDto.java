package dto;

import lombok.Data;

@Data
public class CountrySaveRequestDto {

    private String countryName;
    private String countryCode;
    private int countryId;
}
