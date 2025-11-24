package com.delivery_back.deliveryBack.enums;

public enum PackageStates {
    UNDER_CONSTRUCTION("Armando el pedido"),
    ON_WAY("Em camino"),
    DELIVERED("Entregado");

    private String stateDescription;

    PackageStates(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    public String getStateDescription() {
        return stateDescription;
    }
}
