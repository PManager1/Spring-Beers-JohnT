package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {


    List<Beer> listBeers();

    //  Following is a  Method
    Beer getBeerById(UUID id);

}
