package com.delivery_back.deliveryBack.mapper;

import com.delivery_back.deliveryBack.dto.PackageDTO;
import com.delivery_back.deliveryBack.entity.PackageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackageMapper {

    PackageDTO toDTO(PackageEntity entity);
    PackageEntity toEntity(PackageDTO dto);

}
