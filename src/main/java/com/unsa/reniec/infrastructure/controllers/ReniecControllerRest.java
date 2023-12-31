package com.unsa.reniec.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import com.unsa.reniec.application.services.PersonServiceMySql;
import com.unsa.reniec.application.services.ReniecForeignService;
import com.unsa.reniec.domain.dtos.PersonRequestDto;
import com.unsa.reniec.domain.dtos.PersonResponseDto;

@RestController
@RequestMapping("/api/reniec/people")
@AllArgsConstructor
public class ReniecControllerRest implements ReniecController {

    @Qualifier(value = "reniec-apis-net-open-feign")
    private ReniecForeignService reniecForeignService;
    private PersonServiceMySql personServiceMySql;

    @Override
    @GetMapping
    public PersonResponseDto getByDocument(@RequestParam("number") String document) {
        PersonResponseDto reniecResponse = this.reniecForeignService.getPersonByDocument(document);
        if (reniecResponse == null) {
           return this.personServiceMySql.findByDocument(document);
        }
        return reniecResponse;
    }

    @Override
    @PostMapping
    public PersonResponseDto create(@RequestBody PersonRequestDto personRequestDto) {
        return this.personServiceMySql.createPerson(personRequestDto);
    }

    @Override
    public PersonResponseDto update(PersonRequestDto personRequestDto) {
        return null;
    }

    @Override
    public PersonRequestDto delete(String document) {
        return null;
    }

}
