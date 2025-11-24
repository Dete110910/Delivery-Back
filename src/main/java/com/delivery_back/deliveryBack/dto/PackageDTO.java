package com.delivery_back.deliveryBack.dto;

import com.delivery_back.deliveryBack.enums.PackageStates;

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
        List<String> trackingHistory
) {
}
