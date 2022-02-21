package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="COUNTRY")
public class CountryEntity {

    @Id
    @SequenceGenerator(name = "CountryEntity" ,sequenceName = "COUNTRY_ID_SEQ")
    @GeneratedValue( generator = "CountryEntity" ,strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    @Column(name = "COUNTRY_ID")
    private int countryId;



}
