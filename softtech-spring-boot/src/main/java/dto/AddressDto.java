package dto;

import lombok.Data;

@Data
public class AddressDto {

    private long id;
    private String country;
    private String city;
    private String town;
    private String neighborhood;
    private String street;
    private String doorNumber;
    private String apartmentNumber;
}
