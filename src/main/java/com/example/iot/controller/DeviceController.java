package com.example.iot.controller;

import com.example.iot.service.DeviceService;
import org.example.Device;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {
    private final DeviceService service;

    public DeviceController(DeviceService service) {
        this.service = service;
    }
    @GetMapping
    public List<Device> getAllDevices(){
        return service.getAllDevices();
    }
    @GetMapping("/{id}")
    public Device getDevice(@PathVariable String id){
        return service.getDeviceById(id);
    }
    @PostMapping("/{id}/toggle")
    public String toggleDevice(@PathVariable String id){
        boolean result = service.toggleDevices(id);
        return result ? "Device toggled successfully." : "Device not found.";
    }


}
