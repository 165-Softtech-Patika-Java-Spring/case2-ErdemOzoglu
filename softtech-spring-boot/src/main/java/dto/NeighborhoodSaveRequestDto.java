package dto;

import lombok.Data;

@Data
public class NeighborhoodSaveRequestDto {

    private String neighborhoodName;
    private int  neighborhoodId;
    private int districtId;
}
