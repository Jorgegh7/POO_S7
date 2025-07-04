package servicio;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import modelo.PrimeSecure;

public class Encriptar {

    public static PrimeSecure listaNumerosUtilizados = new PrimeSecure();
    public static HashMap<Integer , String> mensajeEncriptado = new HashMap<>();

    public static int encriptar(){
        int key;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Ingresa el mensaja que deseas encriptar");
        String mensaje = scanner.nextLine();

        do{
            int index = random.nextInt(PrimeSecure.getListaNumerosPrimos().size()-1);
            key = PrimeSecure.getListaNumerosPrimos().get(index);

        }while(listaNumerosUtilizados.contains(key));

        System.out.println("La clave de tu mensaje es: " + key);
        System.out.println();

        mensajeEncriptado.put(key, mensaje);
        listaNumerosUtilizados.add(key);
        PrimeSecure.getListaNumerosPrimos().remove((Integer) key);
        return key;

    }
}
