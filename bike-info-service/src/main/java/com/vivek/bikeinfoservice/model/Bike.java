package com.vivek.bikeinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {

private String bikeId;
private String bikeName;
private String bikeDescription;
}

