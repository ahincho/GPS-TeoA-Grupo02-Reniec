package com.unsa.reniec.domain.entities;

import jakarta.persistence.*;

import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel {

    private Integer id;
    private String name;
    private String fatherLastname;
    private String motherLastname;
    private String documentNumber;
    private String checkDigit;

}
