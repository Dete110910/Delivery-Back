package com.delivery_back.deliveryBack.service;

import com.delivery_back.deliveryBack.dto.PackageDTO;
import com.delivery_back.deliveryBack.dto.TrackingHistoryDTO;
import com.delivery_back.deliveryBack.entity.PackageEntity;
import com.delivery_back.deliveryBack.entity.TrackingEvent;
import com.delivery_back.deliveryBack.mapper.PackageMapper;
import com.delivery_back.deliveryBack.mapper.TrackingHistoryMapper;
import com.delivery_back.deliveryBack.repository.PackageRepository;
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
    //TODO Handle global errors with @ControllerAdvice or @RestControllerAdvice
    //TODO validate null inputs
    //TODO implements STOMP

    public PackageDTO getPackageById(Long id) {
        PackageEntity packageEntity = packageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Package not found"));
        return packageMapper.toDTO(packageEntity);
    }

    public PackageDTO addTrackingEvent(Long id, TrackingHistoryDTO eventDTO) {
        PackageEntity packageEntity = packageRepository.findById(id).orElse(new PackageEntity());
        TrackingEvent eventEntity = trackingHistoryMapper.toEntity(eventDTO);
        eventEntity.setPkg(packageEntity);
        packageEntity.addTrackingEvent(eventEntity);
        packageRepository.save(packageEntity);
        return packageMapper.toDTO(packageEntity);
    }
}
