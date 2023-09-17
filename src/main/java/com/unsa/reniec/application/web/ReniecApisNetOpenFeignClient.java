package com.unsa.reniec.application.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.unsa.reniec.domain.dtos.ReniecApisNetResponse;

@FeignClient(name = "reniec-apis-net-feign-client", url = "https://api.apis.net.pe/v2/reniec/dni")
public interface ReniecApisNetOpenFeignClient {

    @RequestMapping(method = RequestMethod.GET)
    ReniecApisNetResponse getPersonByDocument(@RequestHeader(value = "Authorization", required = true) String bearerToken, @RequestParam("numero") String document);

}
