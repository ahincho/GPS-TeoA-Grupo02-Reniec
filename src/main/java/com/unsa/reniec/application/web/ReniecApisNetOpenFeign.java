package com.unsa.reniec.application.web;

import com.unsa.reniec.domain.dtos.PersonResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "reniec-apis-net", url = "https://api.apis.net.pe/v2/reniec/dni")
public interface ReniecApisNetOpenFeign {

    @GetMapping("{document}")
    PersonResponseDto getPersonByDocument(@PathVariable("document") String document);

}
