package com.mfr.tracker.model;

import lombok.Data;

@Data
public class Device {
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