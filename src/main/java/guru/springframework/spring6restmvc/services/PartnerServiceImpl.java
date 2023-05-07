package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerStyle;
import guru.springframework.spring6restmvc.model.Partner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class PartnerServiceImpl implements PartnerService {
    private Map<UUID, Partner> partnerMap;

    //    Constructor below of no args.
    public PartnerServiceImpl() {
        this.partnerMap = new HashMap<>();

        Partner p1 = Partner.builder()
                .id(UUID.randomUUID())
                .firstName("Darin")
                .lastName("Daignault")
                .email("ddaignault@hubspotpartners.com")
                .country("United States")
                .availableDates(Collections.singletonList("2017-05-03"))
                .availableDates(Collections.singletonList("2017-05-06"))
                .build();

        Partner p2 = Partner.builder()
                .id(UUID.randomUUID())
                .firstName("Crystal")
                .lastName("Brenna")
                .email("cbrenna@hubspotpartners.com")
                .country("Ireland")
                .availableDates(Collections.singletonList("2017-04-27"))
                .availableDates(Collections.singletonList("2017-04-29"))
                .availableDates(Collections.singletonList("2017-04-30"))
                .build();

        Partner p3 = Partner.builder()
                .id(UUID.randomUUID())
                .firstName("Janyce")
                .lastName("Gustison")
                .email("jgustison@hubspotpartners.com")
                .country("Spain")
                .availableDates(Collections.singletonList("2017-04-29"))
                .availableDates(Collections.singletonList("2017-04-30"))
                .availableDates(Collections.singletonList("2017-05-01"))
                .build();


        Partner p4 = Partner.builder()
                .id(UUID.randomUUID())
                .firstName("Tifany")
                .lastName("Mozie")
                .email("TMozie@hubspotpartners.com")
                .country("Spain")
                .availableDates(Collections.singletonList("2017-04-28"))
                .availableDates(Collections.singletonList("2017-04-29"))
                .availableDates(Collections.singletonList("2017-05-01"))
                .availableDates(Collections.singletonList("2017-05-04"))
                .build();


        Partner p5 = Partner.builder()
                .id(UUID.randomUUID())
                .firstName("Temple")
                .lastName("Affelt")
                .email("taffelt@hubspotpartners.com")
                .country("Spain")
                .availableDates(Collections.singletonList("2017-04-28"))
                .availableDates(Collections.singletonList("2017-04-29"))
                .availableDates(Collections.singletonList("2017-05-02"))
                .availableDates(Collections.singletonList("2017-05-04"))
                .build();

        Partner p6 = Partner.builder()
                .id(UUID.randomUUID())
                .firstName("Robyn")
                .lastName("Yarwood")
                .email("RYarwood@hubspotpartners.com")
                .country("Spain")
                .availableDates(Collections.singletonList("2017-04-29"))
                .availableDates(Collections.singletonList("2017-04-30"))
                .availableDates(Collections.singletonList("2017-05-02"))
                .availableDates(Collections.singletonList("2017-05-03"))
                .build();
        Partner p7 = Partner.builder()
                .id(UUID.randomUUID())
                .firstName("Shirlene")
                .lastName("Filipponi")
                .email("SFilipponi@hubspotpartners.com")
                .country("Spain")
                .availableDates(Collections.singletonList("2017-04-30"))
                .availableDates(Collections.singletonList("2017-05-01"))
                .build();

        Partner p8 = Partner.builder()
                .firstName("Oliver")
                .lastName("Majica")
                .email("OMajica@hubspotpartners.com")
                .country("Spain")
                .availableDates(Collections.singletonList("2017-04-28"))
                .availableDates(Collections.singletonList("2017-04-29"))
                .availableDates(Collections.singletonList("2017-05-01"))
                .availableDates(Collections.singletonList("2017-05-03"))
                .build();


        Partner p9 = Partner.builder()
                .firstName("Wilber")
                .lastName("Zartman")
                .email("WZartman@hubspotpartners.com")
                .country("Spain")
                .availableDates(Collections.singletonList("2017-04-29"))
                .availableDates(Collections.singletonList("2017-04-30"))
                .availableDates(Collections.singletonList("2017-05-02"))
                .availableDates(Collections.singletonList("2017-05-03"))
                .build();
        Partner p10 = Partner.builder()
                .firstName("Eugena")
                .lastName("Auther")
                .email("EAuther@hubspotpartners.com")
                .country("United States")
                .availableDates(Collections.singletonList("2017-05-04"))
                .availableDates(Collections.singletonList("2017-05-09"))
                .build();

        partnerMap.put(p1.getId(), p1);
        partnerMap.put(p2.getId(), p2);
        partnerMap.put(p3.getId(), p3);
        partnerMap.put(p4.getId(), p4);
        partnerMap.put(p5.getId(), p5);
        partnerMap.put(p6.getId(), p6);
        partnerMap.put(p7.getId(), p7);
    }


    @Override
    public List<Partner> listPartners() {
        return new ArrayList<>(partnerMap.values());
    }
}

//    @Override
//    public Beer getBeerById(UUID id) {
////        with builder pattern you dont need to new an object, set propertie and then do stuff  .
////        Builder pattern is easy.
//
//        log.debug("Get Beer id in serice was called");
//
//        return beerMap.get(id);
//    }




