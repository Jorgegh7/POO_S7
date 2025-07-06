package app;

import java.util.Scanner;
import modelo.PrimeSecure;
import servicio.Encriptar;
import servicio.Desencriptar;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcionMenu;

        do{
            System.out.println("===========================\n-       PRIMESECURE       -\n===========================");
            System.out.println("1. Encriptar Mensaje");
            System.out.println("2. Desencriptar Mensaje");
            System.out.println("3. Lista numeros primos disponibles");
            System.out.println("4. Lista numeros primos utilizados");
            System.out.println("5. Salir");
            System.out.println("===========================");
            System.out.println("Ingresa tu opción:");
            opcionMenu = scanner.nextInt();

            PrimeSecure.inicializarNumeroPrimo();
            PrimeSecure.reponerLista();

            switch (opcionMenu){
                case 1:
                    Encriptar.encriptar();

                    break;
                case 2:
                    Desencriptar.desencriptar();
                    break;
                case 3:
                    PrimeSecure.mostrarListaNumerosDisponibles();
                    break;
                case 4:
                    PrimeSecure.mostrarListaNumerosUtilizados();
                    break;
                case 5:
                    System.out.println("Hasta la proxima!");
                    break;

                default:
                    System.out.println("El valor ingresado es invalido");
            }


        }while(opcionMenu !=5);
    }
}
