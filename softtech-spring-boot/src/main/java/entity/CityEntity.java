package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="CITY")
public class CityEntity {

    @Id
    @SequenceGenerator(name = "CityEntity" ,sequenceName = "CITY_ID_SEQ")
    @GeneratedValue( generator = "CityEntity" ,strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "CITY_NAME")
    private String CityName;

    @Column(name = "CITY_PLATE_NUMBER")
    private int CityPlateNumber;

    @Column(name = "CITY_ID")
    private int CityId;

    @Column(name = "COUNTRY_ID")
    private int CountryId;




}
