package com.deliveryBack.dto;

import java.time.LocalDate;
import java.util.List;

public record PackageDTO(
        Long id,
        String currentState,
        String origin,
        String destination,
        String ownerName,
        String deliverName,
        LocalDate dispatchDate,
        int amountUnits,
        List<TrackingHistoryDTO> trackingHistory
) {
}
