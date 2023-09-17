package com.unsa.reniec.domain.entities;

import jakarta.persistence.*;

import lombok.*;

@Entity(name = "person")
@Table(name = "people")
@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String fatherLastname;
    private String motherLastname;
    private String documentNumber;
    private String checkDigit;

}