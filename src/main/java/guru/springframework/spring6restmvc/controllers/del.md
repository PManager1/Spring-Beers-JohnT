
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/execute")


public class deleteController {


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


// Imp -  From Video 4 Accessing
        Collection<Partner> partners = new ArrayList<>(Arrays.asList(partnerArray));

        for (Partner part : partners) {
            System.out.println(part.getFirstName());
        }

//        Not working
        for (Partner part : partners) {
            if ( part.getFirstName() == "Crystal" ){
                System.out.println("67--part.getLastName()"+ part.getLastName());
            }
        }
        partners.stream().filter(new Predicate<Partner>() {
            @Override
            public boolean test(Partner partner) {
                return partner.getFirstName().equals("Crystal");
//                return false;
            }
        }).forEach(partner -> System.out.println("79-partner.getLastName ="+partner.getLastName()));



        System.out.println("83- country----------- ");
        partners.stream().filter(new Predicate<Partner>() {
            @Override
            public boolean test(Partner partner) {
                return partner.getCountry().equals("Spain");
//                return false;
            }
        }).forEach(partner -> System.out.println("79-partner.getLastName ="+partner.getFirstName()));
//
//            @Override
//            public void accept(Partner partner) {
//
//            }
//        });

        System.out.println("101- country  2----------- ");

        partners.stream().filter(new Predicate<Partner>() {
            @Override
            public boolean test(Partner partner) {
                return partner.getAvailableDates().contains("2017-05-01");  //.equals("2017-04-30");
//                return false;
            }
        }).forEach(new Consumer<Partner>() {
            @Override
            public void accept(Partner partner) {
                System.out.println(partner.getFirstName());
            }
        });



//        Here filtering the objects by country.
        partners.stream() // Here Room is the type
                .filter ( room ->  room.getCountry().equals("Spain") )
                .forEach(  room ->  System.out.println("122 - Spain Names="+ room.getEmail() ));


// Here filtering the objects if they have the next date available ?
        partners.stream() // Here Room is the type
                .filter ( room ->  room.getCountry().equals("Spain") )
                .forEach(  room ->  System.out.println("128 - Spain Names="+ room.getEmail() ));


        // Get the list of dates in the object.
        //For each date in the list of dates
        // Use above method to get the next date.
        // If the next date exists, save it somewhere.

// Get the list of dates in the object.
        partners.stream() // Here Room is the type;
                .forEach ( room ->  System.out.println("138--- Spain Names="+ room.getAvailableDates() )); //  room.getAvailableDates() )


// DATE STUFF 
//                    LocalDate date = LocalDate.parse("2017-04-30");
//                    LocalDate date2 = date.plusDays(1);
//                    System.out.println("Date "+date+" plus 5 days is "+date2);



        return null;
    }
}

*/