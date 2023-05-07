package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.model.Partner;
import guru.springframework.spring6restmvc.services.PartnerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/partner")


public class PartnerController {

    private final PartnerService partnerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Partner> listPartners(){
        return partnerService.listPartners();
    }



}
