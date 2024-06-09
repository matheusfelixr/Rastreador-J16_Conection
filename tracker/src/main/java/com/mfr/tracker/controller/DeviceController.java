package com.mfr.tracker.controller;

import com.mfr.tracker.dto.config.ResponseApi;
import com.mfr.tracker.model.Device;
import com.mfr.tracker.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/create")
    public ResponseApi<Device> createDevice(@RequestBody Device device) {
        return deviceService.createDevice(device);
    }

    @GetMapping("/all")
    public ResponseApi<List<Device>> getDevices() {
        return deviceService.getDevices();
    }

    @GetMapping("/{id}")
    public ResponseApi<Device> getDeviceById(@PathVariable Long id) {
        return deviceService.getDeviceById(id);
    }
}
