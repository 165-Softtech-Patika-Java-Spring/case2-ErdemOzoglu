package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="STREET")
public class StreetEntity {

    @Id
    @SequenceGenerator(name = "StreetEntity" ,sequenceName = "STREET_ID_SEQ")
    @GeneratedValue( generator = "StreetEntity" ,strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "STREET_ID")
    private int streetId;

    @Column(name = "NEIGHBORHOOD_ID")
    private int  neighborhoodId;



}