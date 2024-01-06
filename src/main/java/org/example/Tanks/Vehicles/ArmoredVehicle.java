package org.example.Tanks.Vehicles;

import org.example.Tanks.Vehicles.Acstracts.Vehicle;

import java.util.Objects;

public abstract class ArmoredVehicle implements Vehicle {
    private int fuelLavel = 0;
    private final int maxFuelLavel;
    private final int fuelСonsumptionOn100;

    private final String type;

    public ArmoredVehicle(int maxFuelLavel, int fuelСonsumptionOn100, String type) {
        this.fuelСonsumptionOn100 = fuelСonsumptionOn100;
        this.maxFuelLavel = maxFuelLavel;
        this.type = type;
    }

    public int getFuelLevel() {
        return fuelLavel;
    }

    public void refuel(int liters) {
        if (fuelLavel + liters > maxFuelLavel) {
            fuelLavel = maxFuelLavel;
        } else {
            fuelLavel += liters;
        }
        System.out.println("Топливо залито");
    }

    public boolean canGoToPoint(int distance) {
        return fuelLavel / fuelСonsumptionOn100 * 100 >= distance;
    }

    public boolean goToPoint(String point, int distance) throws InterruptedException {
        if (canGoToPoint(distance)) {
            System.out.println("Выдвикаемся к " + point);
            Thread.sleep(1000L * distance);
            System.out.println("Доехал до " + point);
            fuelLavel -= (distance * fuelСonsumptionOn100) / 100;
            return true;
        } else {
            System.out.println("Не хватит топлива");
            return false;
        }
    }

    public int getMaxFuelLavel() {
        return maxFuelLavel;
    }

    public int getFuelСonsumptionOn100() {
        return fuelСonsumptionOn100;
    }

    public String getType() {
        return type;
    }

    public String whoIs() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(((ArmoredVehicle) obj).type, this.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return type;
    }
}