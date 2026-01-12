package com.deliveryBack.controller;

import com.deliveryBack.dto.PackageDTO;
import com.deliveryBack.dto.TrackingHistoryDTO;
import com.deliveryBack.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageRestController {

    @Autowired
    private PackageService packageService;

    @GetMapping("/trackOrder/{id}")
    public ResponseEntity<PackageDTO> getPackageById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.packageService.getPackageById(id));
    }

    @PostMapping("/addTrackingEvent/{id}")
    public ResponseEntity<PackageDTO> addTrackingEvent(@PathVariable("id") Long id, @RequestBody TrackingHistoryDTO trackingHistoryDTO) {
        return ResponseEntity.ok(this.packageService.addTrackingEvent(id, trackingHistoryDTO));
    }
}
