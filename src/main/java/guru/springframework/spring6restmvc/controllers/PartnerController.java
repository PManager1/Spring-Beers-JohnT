package guru.springframework.spring6restmvc.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.spring6restmvc.model.Partner;
import guru.springframework.spring6restmvc.services.PartnerService;
import io.micrometer.observation.Observation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
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
import java.util.logging.Logger;
import java.util.stream.Collectors;



@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/execute")



//Remove auto
public class PartnerController {


    private final RestTemplateBuilder restTemplateBuilder;
    private static final String BASE_URL = "http://localhost:8081";
    private static final String GET_BEER_PATH = "/api/v1/partner";

    @RequestMapping(method = RequestMethod.GET)
    public List<Partner> listPartners() {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<Partner[]> responseEntity =
                restTemplate.getForEntity(BASE_URL + GET_BEER_PATH, Partner[].class);

        Partner[] partnerArray = responseEntity.getBody();
// Imp -  From Video 4 Accessing

        Collection <Partner> partners = new ArrayList<>(Arrays.asList(partnerArray));

        System.out.println( "59--- if this with contains ? " + partners);

//        Map<String, List<Partner>> studlistGrouped =
//                partners.stream().collect(Collectors.groupingBy(w -> w.getCountry()));
//        System.out.println( "62studlistGrouped=" + studlistGrouped );
//
//        Map.Entry String,  firstEntry = studlistGrouped.entrySet().iterator().next();
//        System.out.println("First key: " + firstEntry.getKey());
//        System.out.println("First value: " + firstEntry.getValue());


        HashMap< Partner, List<String>> selectedHM = new HashMap<>();

        for (int i =0; i<partnerArray.length; i++ ){
            System.out.println( "65 - if this with contains ? " + partnerArray[i].getAvailableDates().contains("2017-04-30"));
            System.out.println("66- current= searching next date=  2017-04-30  inside of the array = "+  partnerArray[i].getAvailableDates());

// Use ConsecutiveDates to
//            HashMap<Integer, String> selectedHM = new HashMap<Integer, String>();
            List <String> ConsecutiveDates = new ArrayList<String>();
// Inside each object of an array of Objects.
//            String [] array_of_Dates = partnerArray[i].getAvailableDates()
//            Inside getAvailableDates() of the first ArrayList.
                for ( int j=0; j<partnerArray[i].getAvailableDates().size(); j++ ){

                    System.out.println( "73----Each Date inside one Object=" + partnerArray[i].getAvailableDates().get(j) );

                    String tempcurrentDate = partnerArray[i].getAvailableDates().get(j);
                        LocalDate currentDate = LocalDate.parse(tempcurrentDate);
                        LocalDate nextdate = currentDate.plusDays(1);
                        System.out.println("81-Date ------------"+currentDate+" plus 1 days is "+nextdate);

                        System.out.println("83-partnerArray[i].getAvailableDates() ="+partnerArray[i].getAvailableDates());

                            String nextdateSt = nextdate.toString();
                        System.out.println("86---yes it contains ="+ partnerArray[i].getAvailableDates().contains(nextdateSt));
// Inspecting if availableDates contain tomorrow ( nextDate ).
// put the email and the dates inside the selectedMap.
                            boolean contains = partnerArray[i].getAvailableDates().contains(nextdateSt);


//                            System.out.format("86-Testing %s with result ", partnerArray[i].getAvailableDates(), nextdate);
                            System.out.println("91- current= "+currentDate+ " & searching next date= " + nextdate +"  inside of the array = "+  partnerArray[i].getAvailableDates());
                            System.out.println("92---yes it contains ="+ contains);
                        if (contains){
                            System.out.println("94---yes it contains");
                            ConsecutiveDates.add(currentDate.toString());
                        }
                    System.out.println("107- for first="+ partnerArray[i].getFirstName()+"  ConsecutiveDates are = "+  ConsecutiveDates);

                }

    selectedHM.put(partnerArray[i], ConsecutiveDates );

                System.out.println("111--selectedHM ConsecutiveDates are in selectedHM"+  selectedHM);

        }

        System.out.println("116--selectedHM ( COMING CORRECT ) are in selectedHM"+  selectedHM);




        return null;
    }
}
