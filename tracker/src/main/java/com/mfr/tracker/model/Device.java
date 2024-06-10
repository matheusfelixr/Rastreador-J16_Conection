package com.mfr.tracker.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;
    private String carName;
    private String licensePlate;
    private Double latitude;
    private Double longitude;
    private String imageUrl;
    private String imei;
    private String chip;
    private String phone;

    @OneToMany( fetch = FetchType.LAZY)
    @JoinTable(name = "DEVICE_ROUTE", joinColumns = {@JoinColumn(name = "DEVICE_id")}, inverseJoinColumns = {@JoinColumn(name = "ROUTE_id")})
    private List<Route> routes;
}