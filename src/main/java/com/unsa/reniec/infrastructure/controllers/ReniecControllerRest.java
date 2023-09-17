package com.unsa.reniec.infrastructure.controllers;

import com.unsa.reniec.application.services.PersonServiceMySql;
import com.unsa.reniec.application.services.ReniecForeignService;
import com.unsa.reniec.domain.dtos.PersonRequestDto;
import com.unsa.reniec.domain.dtos.PersonResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reniec/people")
@AllArgsConstructor
public class ReniecControllerRest implements ReniecController {

    private ReniecForeignService reniecForeignService;
    private PersonServiceMySql personServiceMySql;

    @Override
    @GetMapping
    public PersonResponseDto getByDocument(@RequestParam("number") String document) {
        return this.reniecForeignService.getPersonByDocument(document);
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
