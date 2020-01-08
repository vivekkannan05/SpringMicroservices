package com.vivek.bikecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {

private String bikeId;
private String bikeName;
private String bikeDescription;
}

