package org.example.Tanks.Vehicles.Acstracts.Tanks;

import org.example.Tanks.Cannons.Armament;
import org.example.Tanks.Vehicles.ArmoredVehicle;

public abstract class Tank extends ArmoredVehicle {

    Armament cannon;

    private static int numbers;
    private final int number;

    public Tank(int maxFuelLavel, int fuelСonsumptionOn100, Armament cannon, String type) {
        super(maxFuelLavel, fuelСonsumptionOn100, type);
        this.cannon = cannon;
        numbers++;
        number = numbers;
    }

    public void reloadAmmunition(int numberOfAmmunition) {
        cannon.reloadAmmunition(numberOfAmmunition, whoIs());
    }

    public void fire(int consumption) throws InterruptedException {
        cannon.fire(consumption, whoIs());
    }
    public int getAmmunitionQuantity() {
        return cannon.getAmmunitionQuantity();
    }

    public String getArmamentType() {
        return cannon.getType();
    }

    public void asyncFire(int consumption) {
        cannon.asyncFire(consumption, whoIs());
    }

    public void reloadAmmunition() {
        cannon.reloadAmmunition(cannon.getMaxAmmunitionQuantity(), whoIs());
    }

    private int getNumber() {
        return number;
    }

    @Override
    public boolean goToPoint(String point, int distance) throws InterruptedException {
        return super.goToPoint(whoIs() + " " + point, distance);
    }

    @Override
    public String whoIs() {
        return this.getType() + " Бортовой номер " + this.getNumber();
    }
}
