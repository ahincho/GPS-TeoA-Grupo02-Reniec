package com.unsa.reniec.infrastructure.controllers;

import com.unsa.reniec.domain.dtos.PersonRequestDto;
import com.unsa.reniec.domain.dtos.PersonResponseDto;

public interface ReniecController {

    PersonResponseDto getByDocument(String document);
    PersonResponseDto create(PersonRequestDto personRequestDto);
    PersonResponseDto update(PersonRequestDto personRequestDto);
    PersonRequestDto delete(String document);

}
