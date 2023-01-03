package br.com.peoplemanager.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@DynamicUpdate
@Table(name = "endereco")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_endereco")
    @SequenceGenerator(name = "sequence_endereco", sequenceName = "sequence_endereco", initialValue = 3, allocationSize = 1)
    @Column(name = "id_endereco", nullable = false)
    private Long id;
    @Column(name = "rua", nullable = false)
    private String streetAddress;
    @Column(name = "cep", nullable = false)
    private String zipCode;
    @Column(name = "numero", nullable = false)
    private Integer number;
    @Column(name = "cidade", nullable = false)
    private String city;
    @Column(name = "estado", nullable = false)
    private String state;
    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH,
            CascadeType.REFRESH }, targetEntity = Person.class)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", nullable = false)
    private Person person;
    @Column(name = "endereco_principal", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isMain;
}
