package com.delivery_back.deliveryBack.service;

import com.delivery_back.deliveryBack.dto.PackageDTO;
import com.delivery_back.deliveryBack.entity.PackageEntity;
import com.delivery_back.deliveryBack.mapper.PackageMapper;
import com.delivery_back.deliveryBack.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private PackageMapper packageMapper;

    public PackageDTO getPackageById(Long id) {
        PackageEntity packageEntity = packageRepository.findById(id)
                .orElse(new PackageEntity());
        return packageMapper.toDTO(packageEntity);
    }
}
