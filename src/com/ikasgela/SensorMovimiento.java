package com.ikasgela;

import java.util.Random;

public class SensorMovimiento {
    private final int umbral;
    private final Random r_Umbral = new Random();

    //Constructor
    public SensorMovimiento() {
        this.umbral = r_Umbral.nextInt(100) + 1;
    }

    //Utilities
    public boolean HayMovimiento() {
        return r_Umbral.nextInt(100) + 1 > this.umbral;
    }
}
