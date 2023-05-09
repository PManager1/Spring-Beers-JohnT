package guru.springframework.spring6restmvc.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.spring6restmvc.model.Partner;
import guru.springframework.spring6restmvc.services.PartnerService;
import io.micrometer.observation.Observation;
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

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/execute")


public class PartnerController {

    private final RestTemplateBuilder restTemplateBuilder;
    private static final String BASE_URL = "http://localhost:8081";
    private static final String GET_BEER_PATH = "/api/v1/partner";


// Should be insid the method.


    @RequestMapping(method = RequestMethod.GET)
    public List<Partner> listPartners() {

//        return partnerService.listPartners();
        System.out.println("34- this Execute method is called ");

        RestTemplate restTemplate = restTemplateBuilder.build();


        ResponseEntity<Partner[]> responseEntity =
                restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, Partner[].class);

        Partner[] partnerArray = responseEntity.getBody();


  /*      System.out.println("72-  partnerArray = " + partnerArray);
//        Arrays.stream(partnerArray).toList();
        System.out.println("78-" + Arrays.stream(partnerArray).toList());  */

 // From Video 4 Accessing
        Collection <Partner> partners = new ArrayList<>(Arrays.asList(partnerArray));

        for (Partner part : partners) {
            System.out.println(part.getFirstName());
        }

//        Not working
        for (Partner part : partners) {
            if ( part.getFirstName() == "Crystal" ){
                System.out.println("67--part.getLastName()"+ part.getLastName());
            }
        }

        System.out.println("72--------");
        partners.stream().filter(new Predicate<Partner>() {
            @Override
            public boolean test(Partner partner) {
                return partner.getFirstName().equals("Crystal");
//                return false;
            }
        }).forEach(partner -> System.out.println(partner.getLastName()));





        return null;
    }
}
