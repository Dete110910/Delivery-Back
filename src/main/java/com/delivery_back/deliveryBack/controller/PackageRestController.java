package com.delivery_back.deliveryBack.controller;

import com.delivery_back.deliveryBack.dto.PackageDTO;
import com.delivery_back.deliveryBack.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageRestController {

    @Autowired
    private PackageService packageService;

    @GetMapping("/trackOrder/{id}")
    public PackageDTO getPackageById(@PathVariable("id") Long id) {
        System.out.println("Respuesta: " + this.packageService.getPackageById(id));
        return this.packageService.getPackageById(id);
    }
}
