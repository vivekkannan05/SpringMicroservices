package com.vivek.ratingdataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {

    private String userId;
    private List<BikeRating> bikeRatingList;

    public void initialize (String id){
        this.userId=id;
        this.bikeRatingList = Arrays.asList(
            new BikeRating("1",4),
            new BikeRating("2",7)
        );
    }
}
