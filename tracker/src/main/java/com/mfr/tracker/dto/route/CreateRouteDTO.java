package com.mfr.tracker.dto.route;

import com.mfr.tracker.model.Device;
import com.mfr.tracker.model.Route;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CreateRouteDTO {
    private Double latitude;
    private Double longitude;
    private Long deviceId;

    public static Route convertToEntity(CreateRouteDTO any) {
        Route ret = new Route();
        ret.setLatitude(any.getLatitude());
        ret.setLongitude(any.getLongitude());
        return ret;
    }

    public static CreateRouteDTO convertToDTO(Route any) {
        CreateRouteDTO ret = new CreateRouteDTO();
        ret.setLatitude(any.getLatitude());
        ret.setLongitude(any.getLongitude());
        ret.setDeviceId(any.getId());
        return ret;
    }

    public static List<CreateRouteDTO> convertToListDTO(List<Route> entitys) {
        List<CreateRouteDTO> ret = new ArrayList<CreateRouteDTO>();
        for (Route entity : entitys) {
            ret.add(CreateRouteDTO.convertToDTO(entity));
        }
        return ret;
    }

    public static List<Route> convertToListEntity(List<CreateRouteDTO> DTOs) {
        List<Route> ret = new ArrayList<Route>();
        for (CreateRouteDTO dto : DTOs) {
            ret.add(CreateRouteDTO.convertToEntity(dto));
        }
        return ret;
    }

}
