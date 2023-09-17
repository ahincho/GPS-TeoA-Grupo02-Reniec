package com.unsa.reniec.domain.dtos;

import lombok.*;

@Data @Builder
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponseDto {

    private Integer id;
    private String name;
    private String fatherLastname;
    private String motherLastname;
    private String documentNumber;

}
