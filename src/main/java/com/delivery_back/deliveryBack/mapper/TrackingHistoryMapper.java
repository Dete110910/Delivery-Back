package com.delivery_back.deliveryBack.mapper;

import com.delivery_back.deliveryBack.dto.TrackingHistoryDTO;
import com.delivery_back.deliveryBack.entity.TrackingEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrackingHistoryMapper {

    @Mapping(target = "pkg", ignore = true)
    TrackingEvent toEntity(TrackingHistoryDTO trackingEvent);

    TrackingHistoryDTO toDTO(TrackingEvent trackingEvent);
}
