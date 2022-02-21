package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="DISTRICT")
public class DistrictEntity {

    @Id
    @SequenceGenerator(name = "DistrictEntity" ,sequenceName = "DISTRICT_ID_SEQ")
    @GeneratedValue( generator = "DistrictEntity" ,strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "DISTRICT_NAME")
    private String districtName;

    @Column(name = "DISTRICT_ID")
    private int districtId;

    @Column(name = "CITY_ID")
    private int cityId;


}
