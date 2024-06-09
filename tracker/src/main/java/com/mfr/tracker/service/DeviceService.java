package com.mfr.tracker.service;

import com.mfr.tracker.dto.config.ResponseApi;
import com.mfr.tracker.model.Device;
import com.mfr.tracker.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public ResponseApi<Device> createDevice(Device device) {
        ResponseApi<Device> response = new ResponseApi<>();
        try {
            Device savedDevice = deviceRepository.save(device);
            response.setData(savedDevice);
        } catch (Exception e) {
            response.getErrors().add("Failed to create device: " + e.getMessage());
        }
        return response;
    }

    public ResponseApi<List<Device>> getDevices() {
        ResponseApi<List<Device>> response = new ResponseApi<>();
        try {
            List<Device> devices = deviceRepository.findAll();
            response.setData(devices);
        } catch (Exception e) {
            response.getErrors().add("Failed to retrieve devices: " + e.getMessage());
        }
        return response;
    }

    public ResponseApi<Device> getDeviceById(Long id) {
        ResponseApi<Device> response = new ResponseApi<>();
        try {
            Device device = deviceRepository.findById(id).orElse(null);
            if (device != null) {
                response.setData(device);
            } else {
                response.getErrors().add("Device not found with id: " + id);
            }
        } catch (Exception e) {
            response.getErrors().add("Failed to retrieve device: " + e.getMessage());
        }
        return response;
    }
}
