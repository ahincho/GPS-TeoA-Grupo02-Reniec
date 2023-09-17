package com.unsa.reniec.application.services;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

import com.unsa.reniec.domain.dtos.PersonResponseDto;
import com.unsa.reniec.domain.dtos.ReniecApisNetResponse;

@Service("reniec-apis-net-rest-template")
@AllArgsConstructor
public class ReniecForeignServiceRestTemplate implements ReniecForeignService {

    private final RestTemplate restTemplate;
    private static final String baseUrl = "https://api.apis.net.pe";
    private static final String apiUrl = "/v2/reniec/dni";
    private static final String bearerToken = "your-super-token";

    @Override
    public PersonResponseDto getPersonByDocument(String document) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + bearerToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url = baseUrl + apiUrl + "?numero=" + document;
        ResponseEntity<ReniecApisNetResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, ReniecApisNetResponse.class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            ReniecApisNetResponse person = response.getBody();
            return mapReniecApisNetResponseToPersonResponseDto(person);
        } else {
            // Exception Handler
            return null;
        }
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
