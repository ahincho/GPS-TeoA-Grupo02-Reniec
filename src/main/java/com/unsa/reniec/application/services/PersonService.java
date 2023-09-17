package com.unsa.reniec.application.services;

import java.util.List;

import com.unsa.reniec.domain.dtos.PersonRequestDto;
import com.unsa.reniec.domain.dtos.PersonResponseDto;

public interface PersonService {

    List<PersonResponseDto> findAll();
    PersonResponseDto findById(Integer id);
    PersonResponseDto findByDocument(String document);
    PersonResponseDto createPerson(PersonRequestDto personRequestDto);
    PersonResponseDto updatePerson(PersonRequestDto personRequestDto);
    PersonResponseDto deletePerson(String document);

}
