package com.delivery_back.deliveryBack.enums;

import lombok.Getter;

public enum PackageStates {
    UNDER_CONSTRUCTION("Armando el pedido"),
    ON_WAY("En camino"),
    DELIVERED("Entregado");

    @Getter
    private final String stateDescription;

    PackageStates(String stateDescription) {
        this.stateDescription = stateDescription;
    }
}
