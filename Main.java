import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 1;
        String numero;

        System.out.println("Ingresa tu número:");
        numero = sc.next();
        TelefonoMovil t = new TelefonoMovil(numero);
        do{
            try{
                TelefonoMovil.menu();
                System.out.println("Ingresa la opción deseada:");
                opcion = sc.nextInt();
                t.opciones(opcion,numero,t);
            }catch (InputMismatchException e){
                System.out.println("Debes insertar los tipos adecuados de datos.");
                sc.next();
            }catch (IndexOutOfBoundsException e){
                System.out.println("No hay tantos contactos como índices insertados.");
                sc.next();
            }
        }while(opcion!=0);
    }
}
