package com.vivek.bikecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeRating {

    private String bikeId;
    private int ratingValue;
}


