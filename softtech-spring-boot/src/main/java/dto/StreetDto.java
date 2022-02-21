package dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class StreetDto {

    private long id;
    private String streetName;
    private int streetId;
    private int  neighborhoodId;
}
