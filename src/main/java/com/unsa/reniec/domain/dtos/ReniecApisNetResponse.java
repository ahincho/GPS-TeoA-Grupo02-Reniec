package com.unsa.reniec.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data @Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReniecApisNetResponse {

    @JsonProperty("nombres")
    private String name;
    @JsonProperty("apellidoPaterno")
    private String fatherLastname;
    @JsonProperty("apellidoMaterno")
    private String motherLastname;
    @JsonProperty("tipoDocumento")
    private String documentType;
    @JsonProperty("numeroDocumento")
    private String documentNumber;

}
