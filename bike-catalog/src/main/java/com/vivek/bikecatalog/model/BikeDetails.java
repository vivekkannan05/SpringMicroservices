package com.vivek.bikecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeDetails {

    private String bikeName;
    private String bikeDescription;
    private int bikeRating;
}
