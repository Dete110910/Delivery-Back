package com.deliveryBack.mapper;

import com.deliveryBack.dto.PackageDTO;
import com.deliveryBack.entity.PackageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TrackingHistoryMapper.class)
public interface PackageMapper {

    PackageDTO toDTO(PackageEntity entity);
    PackageEntity toEntity(PackageDTO dto);

}
