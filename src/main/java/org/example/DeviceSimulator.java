package org.example;

import java.util.*;
import java.util.concurrent.*;

public class DeviceSimulator {

    private final List<Device> devices = new ArrayList<>();
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public DeviceSimulator(){
        devices.add(new Device("1", "Thermostat"));
        devices.add(new Device("2", "Motion Sensor"));
        devices.add(new Device("3", "Light Sensor"));
    }

    public void startSimulation(){
        executor.scheduleAtFixedRate(() -> {
            System.out.println("\n[org.example.Device Updates @ " + new Date() + "]");

            for(Device device : devices){
                device.generateData();
                System.out.println(device);
            }
        }, 0, 5, TimeUnit.SECONDS);
    }
    public void stopSimulation(){
        executor.shutdown();
    }
    public List<Device> getDevices(){
        return devices;
    }
}
