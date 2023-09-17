package com.unsa.reniec.application.services;

import com.unsa.reniec.domain.dtos.ReniecApisNetResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.unsa.reniec.application.web.ReniecApisNetOpenFeignClient;
import com.unsa.reniec.domain.dtos.PersonResponseDto;

@Primary
@Service("reniec-apis-net-open-feign")
@AllArgsConstructor
public class ReniecForeignServiceOpenFeign implements ReniecForeignService {

    private ReniecApisNetOpenFeignClient reniecApisNetOpenFeignClient;
    private static final String bearerToken = "your-super-token";

    @Override
    public PersonResponseDto getPersonByDocument(String document) {
        ReniecApisNetResponse reniecApisNetResponse = this.reniecApisNetOpenFeignClient.getPersonByDocument(bearerToken, document);
        return mapReniecApisNetResponseToPersonResponseDto(reniecApisNetResponse);
    }

    private static PersonResponseDto mapReniecApisNetResponseToPersonResponseDto(ReniecApisNetResponse response) {
        return PersonResponseDto.builder()
                .name(response.getName())
                .fatherLastname(response.getFatherLastname())
                .motherLastname(response.getMotherLastname())
                .documentNumber(response.getDocumentNumber())
                .build();
    }

}
