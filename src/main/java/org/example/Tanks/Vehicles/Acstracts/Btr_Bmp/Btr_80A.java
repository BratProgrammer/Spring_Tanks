package org.example.Tanks.Vehicles.Acstracts.Btr_Bmp;

import org.example.Tanks.Cannons.Cannon2A72;

public class Btr_80A  extends Btr {
    public Btr_80A() {
        super(300, 50, new Cannon2A72(300), 8, "БТР-80А");
    }
}
