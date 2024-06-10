package com.mfr.tracker.service;

import com.mfr.tracker.dto.config.ResponseApi;
import com.mfr.tracker.dto.route.CreateRouteDTO;
import com.mfr.tracker.dto.route.RouteDTO;
import com.mfr.tracker.model.Device;
import com.mfr.tracker.model.Route;
import com.mfr.tracker.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private DeviceService deviceService;

    public ResponseApi<RouteDTO> createRoute(CreateRouteDTO routeDTO) {
        ResponseApi<RouteDTO> response = new ResponseApi<>();
        try {
            Optional<Device> optionalDevice = deviceService.findById(routeDTO.getDeviceId());
            if (optionalDevice.isPresent()) {
                Device device = optionalDevice.get();
                System.out.println("\n \n \n -------------------- Do DTo antes de converter -------------------\n");
                System.out.println(routeDTO.getLatitude());
                System.out.println(routeDTO.getLongitude());
                Route route = CreateRouteDTO.convertToEntity(routeDTO);
                route.setTimeLocal(LocalDateTime.now());
                route.setTimeBrasilia(LocalDateTime.now());

                System.out.println("\n \n \n -------------------- Antes de salvar -------------------\n");
                System.out.println(route.getLatitude());
                System.out.println(route.getLongitude());
                Route routeSave = routeRepository.save(route);
                device.getRoutes().add(route);

                deviceService.save(device);

                response.setData(RouteDTO.convertToDTO(routeSave));
            } else {
                response.getErrors().add("Device not found with id: " + routeDTO.getDeviceId());
            }
        } catch (Exception e) {
            response.getErrors().add("Failed to create route: " + e.getMessage());
        }
        return response;
    }

    public ResponseApi<List<RouteDTO>> getRoutes() {
        ResponseApi<List<RouteDTO>> response = new ResponseApi<>();
        try {
            List<Route> routes = routeRepository.findAll();
            response.setData(RouteDTO.convertToListDTO(routes));
        } catch (Exception e) {
            response.getErrors().add("Failed to retrieve routes: " + e.getMessage());
        }
        return response;
    }
}
