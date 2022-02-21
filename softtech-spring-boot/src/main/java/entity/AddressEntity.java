package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="ADDRESS")
public class AddressEntity {

    @Id
    @SequenceGenerator(name = "AddressEntity" ,sequenceName = "ADDRESS_ID_SEQ")
    @GeneratedValue( generator = "AddressEntity" ,strategy = GenerationType.AUTO)
    private long id;

    @Column(name="country")
    private String country;

    @Column(name="city")
    private String city;

    @Column(name="town")
    private String town;

    @Column(name="neighborhood")
    private String neighborhood;

    @Column(name="street")
    private String street;

    @Column(name="doorNumber")
    private String doorNumber;

    @Column(name="apartmentNumber")
    private String apartmentNumber;

}
