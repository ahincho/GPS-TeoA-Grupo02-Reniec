package com.unsa.reniec.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import com.unsa.reniec.application.services.PersonServiceMySql;
import com.unsa.reniec.application.services.ReniecForeignService;
import com.unsa.reniec.domain.dtos.PersonRequestDto;
import com.unsa.reniec.domain.dtos.PersonResponseDto;
import com.unsa.reniec.domain.dtos.ReniecApisNetRequest;


@Controller
@AllArgsConstructor
public class ReniecControllerThymeLeaf {

    @Qualifier(value = "reniec-apis-net-open-feign")
    private ReniecForeignService reniecForeignService;
    private PersonServiceMySql personServiceMySql;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loadIndexPage(Model model) {
        ReniecApisNetRequest reniecApisNetRequest = new ReniecApisNetRequest();
        model.addAttribute("reniecRequest", reniecApisNetRequest);
        return "index";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getByDocument(Model model, @ModelAttribute ReniecApisNetRequest reniecApisNetRequest) {
        String document = reniecApisNetRequest.getDocumentNumber();
        PersonResponseDto person = this.reniecForeignService.getPersonByDocument(document);
        if (person == null) {
            person = this.personServiceMySql.findByDocument(document);
        }
        if (person != null) {
            model.addAttribute("person", person);
            return "viewPerson";
        } else {
            model.addAttribute("personRequest", new PersonRequestDto());
            return "savePerson";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute PersonRequestDto personRequestDto) {
        this.personServiceMySql.createPerson(personRequestDto);
        return "redirect:";
    }

}
