package servicio;

import modelo.PrimeSecure;

import java.util.Scanner;

public class Desencriptar {

    public static void desencriptar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el valor Key para desencriptar el mensaje:");
        int key = scanner.nextInt();
        if(!Encriptar.listaNumerosUtilizados.contains(key)){
            System.out.println("El numero ingresado no se encuentra en la lista de mensajes encriptados.");
            return;
        }
        if(PrimeSecure.isPrime(key)){
            System.out.println("Para la llave: " + key + '\n' + "El mensaje encriptado es el siguiente: " + Encriptar.mensajeEncriptado.get(key));
        }else{
            System.out.println("El numero ingresado no es un numero primo");
        }
        System.out.println();
    }
}
