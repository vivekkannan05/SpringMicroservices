package com.vivek.bikeinfoservice.controller;

import com.vivek.bikeinfoservice.model.Bike;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bikes")
public class BikeInfoController {
    @RequestMapping("/{bikeId}")
    public Bike getBikeInfo(@PathVariable("bikeId") String bikeId){
        return new Bike(bikeId,"BikeName "+bikeId,"");
    }
}
