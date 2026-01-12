package com.deliveryBack.service;

import com.deliveryBack.dto.PackageDTO;
import com.deliveryBack.dto.TrackingHistoryDTO;
import com.deliveryBack.entity.PackageEntity;
import com.deliveryBack.entity.TrackingEvent;
import com.deliveryBack.mapper.PackageMapper;
import com.deliveryBack.mapper.TrackingHistoryMapper;
import com.deliveryBack.repository.PackageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private PackageMapper packageMapper;
    @Autowired
    private TrackingHistoryMapper trackingHistoryMapper;

    //TODO Fix the return of methods. Is not a good practice to return empty objects when something is not found
    //TODO validate null inputs
    //TODO implements STOMP

    public PackageDTO getPackageById(Long id) {
        PackageEntity packageEntity = packageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Package not found"));
        return packageMapper.toDTO(packageEntity);
    }

    public PackageDTO addTrackingEvent(Long id, TrackingHistoryDTO eventDTO) {
        PackageEntity packageEntity = packageRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Package Not Found"));
        TrackingEvent eventEntity = trackingHistoryMapper.toEntity(eventDTO);
        eventEntity.setPkg(packageEntity);
        packageEntity.addTrackingEvent(eventEntity);
        packageRepository.save(packageEntity);
        return packageMapper.toDTO(packageEntity);
    }
}
