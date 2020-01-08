package com.vivek.bikecatalog.controller;

import com.vivek.bikecatalog.model.Bike;
import com.vivek.bikecatalog.model.BikeDetails;
import com.vivek.bikecatalog.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bikecatalog")
public class BikeCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<BikeDetails> getBikeDetails(@PathVariable("userId") String userId){

        UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsData/user/"+userId,UserRating.class);
       List<BikeDetails> bikeDetails= userRating.getBikeRatingList()
            .stream()
            .map(bikeRating -> {
                Bike bike = restTemplate.getForObject("http://localhost:8082/bikes/"+bikeRating.getBikeId(),Bike.class);
                return new BikeDetails(bike.getBikeName(),bike.getBikeDescription(),bikeRating.getRatingValue());
            })
            .collect(Collectors.toList());

       return bikeDetails;
    }
}
