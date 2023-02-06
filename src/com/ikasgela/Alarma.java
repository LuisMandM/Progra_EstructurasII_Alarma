package com.ikasgela;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Alarma {
    private final int pin;
    private boolean activada;
    private String telefono_Aviso;

    //Associations
    private final List<SensorMovimiento> sensores = new ArrayList<>();
    //Others Vars
    private Random r_Alarma = new Random();
    private int intentos_Pin = 3;

    //Constructor
    public Alarma(String telefono_Aviso) {
        this.pin = CrearPin();
        this.activada = false;
        this.telefono_Aviso = telefono_Aviso;

        int num_sensores = r_Alarma.nextInt(5) + 1;
        for (int i = 0; i < num_sensores; i++) {
            SensorMovimiento sensor = new SensorMovimiento();
            sensores.add(sensor);
        }

    }

    //Getters and setters
    public int getPin() {
        return pin;
    }

    public boolean isActivada() {
        return activada;
    }

    public String getTelefono_Aviso() {
        return telefono_Aviso;
    }

    public void setTelefono_Aviso(String telefono_Aviso) {
        this.telefono_Aviso = telefono_Aviso;
    }

    //Utilities
    public void ConsultarSensores() {
        for (int i = 0; i < sensores.size(); i++) {
            if (sensores.get(i).HayMovimiento() && this.activada) {
                System.out.println("Movimiento en el sensor " + (i + 1));
                System.out.println("ALARMA ACTIVADA\nLlamando a: " + this.telefono_Aviso);
                break;
            } else if (sensores.get(i).HayMovimiento() && !this.activada) {
                System.out.println("Movimiento en el sensor " + (i + 1));
            } else {
                System.out.println("Sensor " + (i + 1) + " sin movimiento");
            }
        }
        System.out.println();
    }

    public void Activar() {
        if (!activada) {
            this.activada = true;
            System.out.println("Alarma Activada");
        } else {
            System.out.println("Alarma ya esta Activada");
        }
    }

    public void Desactivar(int pin) {

        if (activada) {
            if (this.pin == pin) {
                this.activada = false;
                System.out.println("Alarma Desactivada");
                intentos_Pin = 3;
            } else if (intentos_Pin > 1) {
                intentos_Pin--;
                System.out.println("Pin Incorrecto\nIntentos disponibles: " + intentos_Pin);
            } else {
                System.out.println("ALARMA ACTIVADA\nLlamando a: " + this.telefono_Aviso);
            }
        } else {
            System.out.println("La Alarma ya se encuentra desactivada");
        }
    }

    public int CrearPin() {
        StringBuilder pin = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            pin.append((r_Alarma.nextInt(10)));
        }
        return Integer.parseInt(pin.toString());
    }

}
