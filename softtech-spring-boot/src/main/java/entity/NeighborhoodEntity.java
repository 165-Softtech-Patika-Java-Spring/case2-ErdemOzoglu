package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="NEIGHBORHOOD")
public class NeighborhoodEntity {

    @Id
    @SequenceGenerator(name = "NeighborhoodEntity" ,sequenceName = "NEIGHBORHOOD_ID_SEQ")
    @GeneratedValue( generator = "NeighborhoodEntityEntity" ,strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NEIGHBORHOOD_NAME")
    private String neighborhoodName;

    @Column(name = "NEIGHBORHOOD_ID")
    private int  neighborhoodId;

    @Column(name = "DISTRICT_ID")
    private int districtId;

}
