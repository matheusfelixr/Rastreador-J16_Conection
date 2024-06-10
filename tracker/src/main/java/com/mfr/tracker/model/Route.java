package com.mfr.tracker.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timeLocal;
    private LocalDateTime timeBrasilia;
    private Double latitude;
    private Double longitude;

}
