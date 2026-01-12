package com.deliveryBack.mapper;

import com.deliveryBack.dto.TrackingHistoryDTO;
import com.deliveryBack.entity.TrackingEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrackingHistoryMapper {

    @Mapping(target = "pkg", ignore = true)
    TrackingEvent toEntity(TrackingHistoryDTO trackingEvent);

    TrackingHistoryDTO toDTO(TrackingEvent trackingEvent);
}
