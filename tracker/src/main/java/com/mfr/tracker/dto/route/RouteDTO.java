package com.mfr.tracker.dto.route;

import com.mfr.tracker.model.Route;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class RouteDTO {
    private Long id;
    private LocalDateTime timeLocal;
    private LocalDateTime timeBrasilia;
    private Double latitude;
    private Double longitude;


    public static Route convertToEntity(RouteDTO any) {
        Route ret = new Route();
        ret.setId(any.getId());
        ret.setTimeLocal(any.getTimeLocal());
        ret.setTimeBrasilia(any.getTimeBrasilia());
        ret.setLatitude(any.getLatitude());
        ret.setLongitude(any.getLongitude());
        return ret;
    }

    public static RouteDTO convertToDTO(Route any) {
        RouteDTO ret = new RouteDTO();
        ret.setId(any.getId());
        ret.setTimeLocal(any.getTimeLocal());
        ret.setTimeBrasilia(any.getTimeBrasilia());
        ret.setLatitude(any.getLatitude());
        ret.setLongitude(any.getLongitude());
        return ret;
    }

    public static List<RouteDTO> convertToListDTO(List<Route> entitys) {
        List<RouteDTO> ret = new ArrayList<RouteDTO>();
        for (Route entity : entitys) {
            ret.add(RouteDTO.convertToDTO(entity));
        }
        return ret;
    }

    public static List<Route> convertToListEntity(List<RouteDTO> DTOs) {
        List<Route> ret = new ArrayList<Route>();
        for (RouteDTO dto : DTOs) {
            ret.add(RouteDTO.convertToEntity(dto));
        }
        return ret;
    }

}
