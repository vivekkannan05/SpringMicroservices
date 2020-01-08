package com.vivek.ratingdataservice.controller;

import com.vivek.ratingdataservice.model.BikeRating;
import com.vivek.ratingdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratingsData")
public class RatingDataController {

@RequestMapping("/bike/{bikeId}")
public BikeRating getBikeRating(@PathVariable("bikeId") String bikeId){
    return new BikeRating(bikeId, 10);
}
@RequestMapping("/user/{userId}")
public UserRating getBikeRatings(@PathVariable("userId") String userId){
    UserRating userRating=  new UserRating();
    userRating.initialize(userId);
    return userRating;
}

}
