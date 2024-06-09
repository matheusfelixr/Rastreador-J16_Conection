package com.mfr.tracker.repository;

import com.mfr.tracker.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}