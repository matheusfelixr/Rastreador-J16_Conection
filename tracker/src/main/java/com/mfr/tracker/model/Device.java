package com.mfr.tracker.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
}