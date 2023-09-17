package com.unsa.reniec.infrastructure.controllers;

import com.unsa.reniec.application.services.ReniecForeignService;
import com.unsa.reniec.domain.dtos.PersonRequestDto;
import com.unsa.reniec.domain.dtos.PersonResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
@AllArgsConstructor
public class ReniecControllerRest implements ReniecController {

    private ReniecForeignService reniecForeignService;

    @Override
    @GetMapping
    public PersonResponseDto getByDocument(@RequestParam("number") String document) {
        return this.reniecForeignService.getPersonByDocument(document);
    }

    @Override
    public PersonResponseDto create(PersonRequestDto personRequestDto) {
        return null;
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
