package com.delivery_back.deliveryBack.entity;

import com.delivery_back.deliveryBack.enums.PackageStates;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class TrackingEvent {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private PackageStates state;
    private String description;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private PackageEntity pkg;

    public TrackingEvent() {
    }

    public TrackingEvent(PackageStates state, String description, LocalDateTime timestamp, PackageEntity pkg) {
        this.state = state;
        this.description = description;
        this.timestamp = timestamp;
        this.pkg = pkg;
    }

    @Override
    public String toString() {
        return "TrackingEvent{" +
                "state=" + state +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
