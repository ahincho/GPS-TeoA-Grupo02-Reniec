package com.unsa.reniec.application.services;

import com.unsa.reniec.domain.entities.PersonEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.util.List;

import com.unsa.reniec.domain.dtos.PersonRequestDto;
import com.unsa.reniec.domain.dtos.PersonResponseDto;
import com.unsa.reniec.domain.repositories.PersonRepository;

@Service
@AllArgsConstructor
public class PersonServiceMySql implements PersonService {

    private PersonRepository personRepository;

    @Override
    public List<PersonResponseDto> findAll() {
        return this.personRepository.findAll().stream().map(PersonServiceMySql::mapPersonEntityToPersonResponseDto).toList();
    }

    @Override
    public PersonResponseDto findById(Integer id) {
        return this.personRepository.findById(id).map(PersonServiceMySql::mapPersonEntityToPersonResponseDto).orElse(null);
    }

    @Override
    public PersonResponseDto findByDocument(String document) {
        return this.personRepository.findByDocumentNumber(document).map(PersonServiceMySql::mapPersonEntityToPersonResponseDto).orElse(null);
    }

    @Override
    public PersonResponseDto createPerson(PersonRequestDto personRequestDto) {
        PersonEntity personEntity = mapPersonRequestDtoToPersonEntity(personRequestDto);
        System.out.println("Name: " + personEntity.getName());
        System.out.println("Father: " + personEntity.getFatherLastname());
        System.out.println("Mother: " + personEntity.getMotherLastname());
        System.out.println("Document: " + personEntity.getDocumentNumber());
        System.out.println("Check: " + personEntity.getCheckDigit());
        return mapPersonEntityToPersonResponseDto(this.personRepository.save(personEntity));
    }

    @Override
    public PersonResponseDto updatePerson(PersonRequestDto personRequestDto) {
        return null;
    }

    @Override
    public PersonResponseDto deletePerson(String document) {
        return null;
    }

    private static PersonResponseDto mapPersonEntityToPersonResponseDto(PersonEntity personEntity) {
        return PersonResponseDto.builder()
                .name(personEntity.getName())
                .fatherLastname(personEntity.getFatherLastname())
                .motherLastname(personEntity.getMotherLastname())
                .documentNumber(personEntity.getDocumentNumber())
                .build();
    }

    private static PersonEntity mapPersonRequestDtoToPersonEntity(PersonRequestDto personRequestDto) {
        return PersonEntity.builder()
                .name(personRequestDto.getName())
                .fatherLastname(personRequestDto.getFatherLastname())
                .motherLastname(personRequestDto.getMotherLastname())
                .documentNumber(personRequestDto.getDocumentNumber())
                .checkDigit(personRequestDto.getCheckDigit())
                .build();
    }

}
