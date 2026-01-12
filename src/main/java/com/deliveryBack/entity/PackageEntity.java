package com.deliveryBack.entity;

import com.deliveryBack.enums.PackageStates;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
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

    @OneToMany(mappedBy = "pkg", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrackingEvent> trackingHistory = new ArrayList();


    public PackageEntity() {
        this.id = 0L;
        this.currentState = null;
        this.origin = null;
        this.destination = null;
        this.ownerName = null;
        this.deliverName = null;
        this.dispatchDate = null;
        this.amountUnits = 0;
        this.trackingHistory = new ArrayList();
    }

    public PackageEntity(PackageStates currentState, String origin, String destination, String ownerName, String deliverName, LocalDate dispatchDate, int amountUnits) {
        this.currentState = currentState;
        this.origin = origin;
        this.destination = destination;
        this.ownerName = ownerName;
        this.deliverName = deliverName;
        this.dispatchDate = dispatchDate;
        this.amountUnits = amountUnits;
        this.trackingHistory = new ArrayList();
    }

    public void addTrackingEvent(TrackingEvent event) {
        this.trackingHistory.add(event);
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
                '}';
    }
}
