package com.unsa.reniec.application.services;

import com.unsa.reniec.domain.dtos.PersonResponseDto;

public interface ReniecForeignService {

    PersonResponseDto getPersonByDocument(String document);

}
