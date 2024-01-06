package org.example.Tanks.Vehicles.Acstracts.Tanks;

import org.example.Tanks.Cannons.Cannon2A46M5;

public class T90_M extends Tank {
    public T90_M() {
        super(1200, 400, new Cannon2A46M5(), "Т-90М");
    }
}
