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
    private Long latitude;
    private Long longitude;

    @ManyToOne
    private Device device;
}
