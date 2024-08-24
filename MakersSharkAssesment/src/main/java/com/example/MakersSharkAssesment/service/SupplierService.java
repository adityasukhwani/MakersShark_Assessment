package com.example.MakersSharkAssesment.service;

import com.example.MakersSharkAssesment.model.Supplier;
import com.example.MakersSharkAssesment.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    // public Supplier addSupplier(Supplier supplier) {
    //     try {
    //         return supplierRepository.save(supplier);
    //     } catch (Exception e) {
    //         System.out.println("Error occurred while saving supplier: " + e.getMessage());
    //         throw e;  // Re-throwing the exception to be handled by the controller
    //     }
    // }

    public List<Supplier> getSuppliers(String location, String natureOfBusiness, String manufacturingProcesses) {
        try {
            return supplierRepository.findSuppliersByLocationNatureOfBusinessAndManufacturingProcesses(
                    location, natureOfBusiness, manufacturingProcesses
            );
        } catch (Exception e) {
            System.out.println("Error occurred while fetching suppliers: " + e.getMessage());
            throw e;  // Re-throwing the exception to be handled by the controller
        }
    }
}
