package com.vivek.ratingdataservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BikeRating {

    private String bikeId;
    private int ratingValue;
}


