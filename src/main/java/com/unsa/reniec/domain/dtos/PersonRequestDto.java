package com.unsa.reniec.domain.dtos;

import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonRequestDto {

    private String name;
    private String fatherLastname;
    private String motherLastname;
    private String documentNumber;
    private String checkDigit;

}
