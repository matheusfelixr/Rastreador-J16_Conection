package com.mfr.tracker.service;

import com.mfr.tracker.dto.config.ResponseApi;
import com.mfr.tracker.dto.route.CreateRouteDTO;
import com.mfr.tracker.model.Device;
import com.mfr.tracker.model.Route;
import com.mfr.tracker.repository.DeviceRepository;
import com.mfr.tracker.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    public ResponseApi<Route> createRoute(CreateRouteDTO routeDTO) {
        ResponseApi<Route> response = new ResponseApi<>();
        try {
            Optional<Device> optionalDevice = deviceRepository.findById(routeDTO.getDeviceId());
            if (optionalDevice.isPresent()) {
                Device device = optionalDevice.get();
                Route route = new Route();
                route.setTimeLocal(routeDTO.getTimeLocal());
                route.setTimeBrasilia(routeDTO.getTimeBrasilia());
                route.setLatitude(routeDTO.getLatitude());
                route.setLongitude(routeDTO.getLongitude());
                Route savedRoute = routeRepository.save(route);

                device.getRoutes().add(savedRoute);
                deviceRepository.save(device);

                response.setData(savedRoute);
            } else {
                response.getErrors().add("Device not found with id: " + routeDTO.getDeviceId());
            }
        } catch (Exception e) {
            response.getErrors().add("Failed to create route: " + e.getMessage());
        }
        return response;
    }

}
