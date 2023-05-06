package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {


//  Following is a  Method
    Beer getBeerById(UUID id);

}
