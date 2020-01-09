package com.vivek.bikecatalog.controller;

import com.vivek.bikecatalog.model.Bike;
import com.vivek.bikecatalog.model.BikeDetails;
import com.vivek.bikecatalog.model.BikeRating;
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

    private final RestTemplate restTemplate;

    @Autowired
    public BikeCatalogController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/{userId}")
    /**
     * In this method we are trying to call 2 Api that would get the details of the bike and its rating based on the user Id passed.
     * The endpoint URL has been changed from exact value to the application name that is registered in Eureka Server.
     * With this it is easy to for the Client to pick the API client instance that is available if it is loadbalanced.
     */
    public List<BikeDetails> getBikeDetails(@PathVariable("userId") String userId){

        UserRating userRating = restTemplate.getForObject("http://rating-data-service/ratingsData/user/"+userId,UserRating.class);
        assert userRating != null;
        return userRating.getBikeRatingList().stream().map(this::fetchbikeDetails).collect(Collectors.toList());

    }

    private BikeDetails fetchbikeDetails(BikeRating bikeRating) {
        Bike bike = restTemplate.getForObject("http://bike-info-service/bikes/" + bikeRating.getBikeId(), Bike.class);
        assert bike != null;
        return new BikeDetails(bike.getBikeName(), bike.getBikeDescription(), bikeRating.getRatingValue());
    }
}
