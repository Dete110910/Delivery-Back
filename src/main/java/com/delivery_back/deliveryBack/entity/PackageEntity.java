package com.delivery_back.deliveryBack.entity;

import com.delivery_back.deliveryBack.enums.PackageStates;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private PackageStates currentState;
    private String origin;
    private String destination;
    private String ownerName;
    private String deliverName;
    private LocalDate dispatchDate;
    private int amountUnits;
    private List<PackageStates> trackingHistory;

    public PackageEntity() {
        this.id = 0L;
        this.currentState = null;
        this.origin = null;
        this.destination = null;
        this.ownerName = null;
        this.deliverName = null;
        this.dispatchDate = null;
        this.amountUnits = 0;
        this.trackingHistory = null;
    }

    public PackageEntity(PackageStates currentState, String origin, String destination, String ownerName, String deliverName, LocalDate dispatchDate, int amountUnits, List<PackageStates> trackingHistory) {
        this.currentState = currentState;
        this.origin = origin;
        this.destination = destination;
        this.ownerName = ownerName;
        this.deliverName = deliverName;
        this.dispatchDate = dispatchDate;
        this.amountUnits = amountUnits;
        this.trackingHistory = trackingHistory;
    }


    public Long getId() {
        return id;
    }

    public PackageStates getCurrentState() {
        return currentState;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getDeliverName() {
        return deliverName;
    }

    public LocalDate getDispatchDate() {
        return dispatchDate;
    }

    public int getAmountUnits() {
        return amountUnits;
    }

    public List<PackageStates> getTrackingHistory() {
        return trackingHistory;
    }

    @Override
    public String toString() {
        return "PackageEntity{" +
                "id=" + id +
                ", currentState=" + currentState +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", dispatchDate=" + dispatchDate +
                ", trackingHistory=" + trackingHistory +
                '}';
    }
}
