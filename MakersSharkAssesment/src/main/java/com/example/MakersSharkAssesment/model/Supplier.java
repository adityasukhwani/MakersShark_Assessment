package com.example.MakersSharkAssesment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

//@Entity
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;
    private String companyName;
    private String website;
    private String location;
    private String natureOfBusiness;
    private String manufacturingProcesses;
    public Supplier(int supplierId, String companyName, String website, String location, String natureOfBusiness, String manufacturingProcesses) {
        this.supplierId = supplierId;
        this.companyName = companyName;
        this.website = website;
        this.location = location;
        this.natureOfBusiness = natureOfBusiness;
        this.manufacturingProcesses = manufacturingProcesses;
    }


}
