package com.example.MakersSharkAssesment.controller;

import com.example.MakersSharkAssesment.model.ResponseDTO;
import com.example.MakersSharkAssesment.model.Supplier;
import com.example.MakersSharkAssesment.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
        @Autowired
        private SupplierService supplierService;
        @PostMapping("/query")
        public ResponseEntity<List<Supplier>> querySuppliers(
                @RequestBody ResponseDTO responseDTO) {
            try {
                prepSupplierObject(responseDTO);
                System.out.println("PREPPED OBJECT: " + responseDTO.toString());
                List<Supplier> suppliers = supplierService.getSuppliers(responseDTO.getLocation(),
                        responseDTO.getNatureOfBusiness(),
                        responseDTO.getManufacturingProcesses());
                return new ResponseEntity<>(suppliers, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        private void prepSupplierObject(ResponseDTO responseDTO){
            responseDTO.setNatureOfBusiness(responseDTO.getNatureOfBusiness().toLowerCase());
            responseDTO.setManufacturingProcesses(responseDTO.getManufacturingProcesses().toLowerCase());
        }


        // @PostMapping("/add")
        // public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        //     try {
        //         Supplier savedSupplier = supplierService.addSupplier(supplier);
        //         return new ResponseEntity<>(savedSupplier, HttpStatus.CREATED);
        //     } catch (Exception e) {
        //         // Handle the exception, return a generic error message
        //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        //     }
        // }
}
