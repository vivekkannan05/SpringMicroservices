package com.vivek.bikecatalog.model;

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

}
