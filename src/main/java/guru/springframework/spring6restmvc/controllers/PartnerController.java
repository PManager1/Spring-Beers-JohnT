package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.model.Partner;
import guru.springframework.spring6restmvc.services.PartnerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/execute")


public class PartnerController {

    private final RestTemplateBuilder restTemplateBuilder;
    private static final String BASE_URL = "http://localhost:8081"; private static final String GET_BEER_PATH = "/api/v1/partner";



// Should be insid the method.




    @RequestMapping(method = RequestMethod.GET)
    public List<Partner> listPartners(){

//        return partnerService.listPartners();
        System.out.println("34- this Execute method is called ");

        RestTemplate restTemplate = restTemplateBuilder.build();

// First, let's make the call with RestTemplate.getForEntity and
// use a ResponseEntity of type Object[] to collect the response:

        ResponseEntity<Object[]> responseEntity =
                restTemplate.getForEntity(BASE_URL + GET_BEER_PATH , Object[].class);

        System.out.println("59-  Coming thru ");

        // Next, we can extract the body into our array of Object:
        Object[] objects = responseEntity.getBody();

        System.out.println("56-  objects = " + objects[0] );

        return null;
    }



}
