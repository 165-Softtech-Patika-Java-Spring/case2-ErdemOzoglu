package dto;

import lombok.Data;

@Data
public class StreetSaveRequestDto {

    private String streetName;
    private int streetId;
    private int  neighborhoodId;
}
