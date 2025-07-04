package modelo;
import servicio.Encriptar;

import java.util.ArrayList;

public class PrimeSecure extends ArrayList<Integer> implements Runnable {
    static PrimeSecure listaNumerosPrimos = new PrimeSecure();


    public static boolean isPrime(int numero) {
        if (numero <= 1) return false;
        if (numero <= 3) return true;
        if (numero % 2 == 0 || numero % 3 == 0) return false;

        int limite = (int) Math.sqrt(numero);

        for (int i = 5; i <= limite; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean add(Integer integer){
        boolean primo = false;
        if(isPrime(integer)){
            super.add(integer);
            primo= true;
        }else{
            throw new IllegalArgumentException ("El número ingresado no es un número primo");
        }
        return primo;
    }

    public static PrimeSecure inicializarNumeroPrimo(){
        Thread hiloInicializarNumeroPrimo = new Thread(new Runnable() {
            @Override
            public void run() {
                if(listaNumerosPrimos.isEmpty()) {
                    for (int i = 2; i < 100; i++) {
                        if (isPrime(i)) {
                            listaNumerosPrimos.add(i);
                        }
                    }
                }

            }
        });
        hiloInicializarNumeroPrimo.start();
        try {
            hiloInicializarNumeroPrimo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return listaNumerosPrimos;
    }

    public static PrimeSecure reponerLista(){
        if(listaNumerosPrimos.size()<30){
            int ultimoPrimo = listaNumerosPrimos.get(listaNumerosPrimos.size()-1) +1;
            int rango = ultimoPrimo *2;
            for(int i = ultimoPrimo;i<rango; i++){
                if (isPrime(i) && !listaNumerosPrimos.contains(i)) {
                    listaNumerosPrimos.add(i);
                }
            }
        }
        return listaNumerosPrimos;
    }

    public static int getPrimesCount(PrimeSecure primeSecure){
        return primeSecure.size();
    }

    public static void mostrarListaNumerosUtilizados(){
        System.out.println("-----------------------------\n-   LISTA N. UTILIZADOS   -\n-----------------------------");
        if(Encriptar.listaNumerosUtilizados.isEmpty()){
            System.out.println("Esta lista se encuentra vacia.\nAun no se han enviado mensajes");
        }else{
            for(int numeroPrimo: Encriptar.listaNumerosUtilizados){
                System.out.println(numeroPrimo);
            }
        }
        System.out.println("Total de mensajes enviados: " + getPrimesCount(Encriptar.listaNumerosUtilizados));
        System.out.println();


    }

    public static PrimeSecure getListaNumerosPrimos(){
        return listaNumerosPrimos;
    }

    public static void mostrarListaNumerosDisponibles(){
        System.out.println("-----------------------------\n-   LISTA N. DISPONIBLES   -\n-----------------------------");
        for(int primo: PrimeSecure.getListaNumerosPrimos()){
            System.out.println(primo);
        }

    }


    @Override
    public void run() {


    }
}
