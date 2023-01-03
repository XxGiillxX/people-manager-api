package br.com.peoplemanager.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequest {
    private String streetAddress;
    private String zipCode;
    private Integer number;
    private String city;
    private String state;
    private Long idPerson;
    private Boolean isMain;
}
