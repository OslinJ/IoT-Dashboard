package org.example;

public class Main {
    public static void main(String[] args) {

        DeviceSimulator simulator = new DeviceSimulator();
        simulator.startSimulation();

        try{
            Thread.sleep(30000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        simulator.stopSimulation();
        System.out.println("Simulation stopped.");

    }
}