package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.model.Partner;

import java.util.List;

public interface PartnerService {

    List<Partner> listPartners();

}
