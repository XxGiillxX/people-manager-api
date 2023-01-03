package br.com.peoplemanager.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "pessoa")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_pessoa")
    @SequenceGenerator(name = "sequence_pessoa", sequenceName = "sequence_pessoa", initialValue = 2, allocationSize = 1)
    @Column(name = "id_pessoa", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String name;
    @Column(name = "data_nasc", nullable = false)
    private LocalDate birthDay;
}
