package com.delivery_back.deliveryBack.dto;

import com.delivery_back.deliveryBack.enums.PackageStates;

import java.time.LocalDateTime;

public record TrackingHistoryDTO(PackageStates state, String description, LocalDateTime timestamp) {
}
