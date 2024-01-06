package org.example.Tanks.Vehicles.Acstracts.CargoCar;

import org.example.Tanks.Vehicles.ArmoredVehicle;

public abstract class CargoCar extends ArmoredVehicle {
    private int maxCargo = 0;
    private int numberOfSoldiers = 0;
    private int cargo;

    public CargoCar(int maxCargo ,int maxFuelLavel, int fuelСonsumptionOn100, String type) {
        super(maxFuelLavel, fuelСonsumptionOn100, type);
        this.maxCargo = maxCargo;
    }



    //TODO getCargo, getSoldiers, landTroops, landCargo
}
