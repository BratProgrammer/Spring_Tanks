package org.example.Tanks.Vehicles.Acstracts.Btr_Bmp;

import org.example.Tanks.Cannons.KPVT;

public class Btr_80 extends Btr {
    public Btr_80() {
        super(300, 50, new KPVT(500), 8, "БТР-80");
    }
}
