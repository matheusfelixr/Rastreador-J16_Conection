package com.mfr.tracker.dto.device;

import com.mfr.tracker.model.Device;
import com.mfr.tracker.model.Route;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class DeviceDTO {
    private Long id;
    private String nickname;
    private String carName;
    private String licensePlate;
    private Double latitude;
    private Double longitude;
    private String imageUrl;
    private String imei;
    private String chip;
    private String phone;
    private LocalDateTime createDate;


    public static Device convertToEntity(DeviceDTO any) {
        Device ret = new Device();
        ret.setId(any.getId());
        ret.setNickname(any.getNickname());
        ret.setCarName(any.getCarName());
        ret.setLicensePlate(any.getLicensePlate());
        ret.setLatitude(any.getLatitude());
        ret.setLongitude(any.getLongitude());
        ret.setImageUrl(any.getImageUrl());
        ret.setImei(any.getImei());
        ret.setChip(any.getChip());
        ret.setPhone(any.getPhone());
        ret.setCreateDate(any.getCreateDate());

        return ret;
    }

    public static DeviceDTO convertToDTO(Device any) {
        DeviceDTO ret = new DeviceDTO();
        ret.setId(any.getId());
        ret.setNickname(any.getNickname());
        ret.setCarName(any.getCarName());
        ret.setLicensePlate(any.getLicensePlate());
        ret.setLatitude(any.getLatitude());
        ret.setLongitude(any.getLongitude());
        ret.setImageUrl(any.getImageUrl());
        ret.setImei(any.getImei());
        ret.setChip(any.getChip());
        ret.setPhone(any.getPhone());
        ret.setCreateDate(any.getCreateDate());

        return ret;
    }

    public static List<DeviceDTO> convertToListDTO(List<Device> entitys) {
        List<DeviceDTO> ret = new ArrayList<DeviceDTO>();
        for (Device entity : entitys) {
            ret.add(DeviceDTO.convertToDTO(entity));
        }
        return ret;
    }

    public static List<Device> convertToListEntity(List<DeviceDTO> DTOs) {
        List<Device> ret = new ArrayList<Device>();
        for (DeviceDTO dto : DTOs) {
            ret.add(DeviceDTO.convertToEntity(dto));
        }
        return ret;
    }

}
