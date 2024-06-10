package com.mfr.tracker.controller;

import com.mfr.tracker.dto.config.ResponseApi;
import com.mfr.tracker.dto.route.CreateRouteDTO;
import com.mfr.tracker.model.Device;
import com.mfr.tracker.model.Route;
import com.mfr.tracker.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/create")
    public ResponseApi<Route> createRoute(@RequestBody CreateRouteDTO route) {
        return routeService.createRoute(route);
    }

    @GetMapping("/all")
    public ResponseApi<List<Route>> getRoutes() {
        return routeService.getRoutes();
    }

}
