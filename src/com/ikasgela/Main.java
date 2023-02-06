package com.ikasgela;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean num_Correcto = true;
        int num_Telefono = 0;
        do {
            System.out.print("Binvenido\nA continuacion indique el numero de Telefono en caso de emergencia: ");
            try {
                num_Telefono = Integer.parseInt(br.readLine());
                num_Correcto = false;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Tipo de dato ingresado Erroneo.");
            }
        } while (num_Correcto);

        Alarma alarma = new Alarma(String.valueOf(num_Telefono));
        System.out.println("Su numero de pin es: " + alarma.getPin()
                + "\nEn este momento su Alarma se encuentra desactivada");
        boolean running = true;

        do {
            System.out.print("\nMenú Alarma\n1. Activar alarma\n" +
                    "2. Desactivar alarma (necesario PIN)\n" +
                    "3. Consultar sensores\n" +
                    "4. Salir\nOpcion: ");
            try {
                int opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1:
                        alarma.Activar();

                        break;
                    case 2:
                        System.out.print("Indique su numero pin: ");
                        try {
                            int pin_Alarma = Integer.parseInt(br.readLine());
                            alarma.Desactivar(pin_Alarma);
                        } catch (NumberFormatException e) {
                            System.out.println("ERROR: Tipo de dato ingresado Erroneo.");
                        }
                        break;
                    case 3:
                        alarma.ConsultarSensores();
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        running = false;
                        break;
                    default:
                        System.out.println("Opcion Invalida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Tipo de dato ingresado Erroneo.");
            }

        } while (running);

    }
}
