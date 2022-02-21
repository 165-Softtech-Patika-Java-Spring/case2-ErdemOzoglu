package dto;

import lombok.Data;

@Data
public class DistrictSaveRequestDto {

    private String districtName;
    private int districtId;
    private int cityId;
}
