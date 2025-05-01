package com.example.iot.service;

import org.example.Device;
import org.example.DeviceSimulator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviceService {
    private final DeviceSimulator simulator;

    public DeviceService(){
        this.simulator = new DeviceSimulator();
        simulator.startSimulation();
    }
    public List<Device> getAllDevices(){
        return simulator.getDevices();
    }
    public Device getDeviceById(String id){
        return simulator.getDevices()
                .stream()
                .filter(device -> device.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public boolean toggleDevices(String id){
        Device device = getDeviceById(id);
        if(device != null){
            device.toggle();
            return true;
        }
        return false;
    }
}
