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

    public Device() {
    }

    public Device(Long id, String nickname, String carName, String licensePlate, Double latitude, Double longitude, String imageUrl, String imei, String chip, String phone, List<Route> routes) {
        this.id = id;
        this.nickname = nickname;
        this.carName = carName;
        this.licensePlate = licensePlate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageUrl = imageUrl;
        this.imei = imei;
        this.chip = chip;
        this.phone = phone;
        this.routes = routes;
    }

    public Device(Long id) {
        this.id = id;
    }
}