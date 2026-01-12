package com.deliveryBack.dto;

import com.deliveryBack.enums.PackageStates;

import java.time.LocalDateTime;

public record TrackingHistoryDTO(PackageStates state, String description, LocalDateTime timestamp) {
}
