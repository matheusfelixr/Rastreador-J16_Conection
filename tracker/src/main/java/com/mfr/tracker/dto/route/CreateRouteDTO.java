package com.mfr.tracker.dto.route;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateRouteDTO {
    private Long id;
    private LocalDateTime timeLocal;
    private LocalDateTime timeBrasilia;
    private Long latitude;
    private Long longitude;
    private Long deviceId;
}
