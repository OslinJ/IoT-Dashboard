package org.example;

import java.util.Random;

public class Device {
    private String id;
    private String name;
    private boolean isActive;
    private double currentValue;

    private static final Random random = new Random();

    public Device(String id, String name){
        this.id = id;
        this.name = name;
        this.isActive = true;
        this.currentValue = 0.0;

    }
    public void generateData(){
        if(isActive){
            this.currentValue = 20 + (80 * random.nextDouble());

        }
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getCurrentValue(){
        return currentValue;
    }
    public void setCurrentValue(double currentValue){
        this.currentValue = currentValue;
    }
    public void toggle(){
        this.isActive = !this.isActive;
    }
    @Override
    public String toString() {
        return String.format("org.example.Device[id=%s, name=%s, active=%s, value=%.2f]",
                getId(), getName(), isActive, getCurrentValue());
    }

}
