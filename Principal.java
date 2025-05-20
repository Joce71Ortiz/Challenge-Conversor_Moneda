
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMonedasDeCambio consultar = new ConsultarMonedasDeCambio();


        int opcion=0;
        while (opcion!=8) {
            System.out.println("\n*********************************************");
            System.out.println("Bienvenido al Conversor de Monedas");
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Dólar (USD) a Peso (ARS)");
            System.out.println("2. Peso Argentino (ARS) a Dólar (USD)");
            System.out.println("3. Dólar (USD) a Real Basileño (BRL)");
            System.out.println("4. Real Brasileño (BRL) a Dólar (USD)");
            System.out.println("5. Dólar (USD) a Peso Colombiano (COP)");
            System.out.println("6. Peso Colombiano (COP) a Dólar (USD)");
            System.out.println("7. Convertir Otra Moneda");
            System.out.println("8. Salir");
            System.out.println("*************************************************");
            System.out.println("Ingrese su opción: ");

            try {
                opcion= lectura.nextInt();
                lectura.nextLine();

                switch (opcion) {
                    case 1:
                        ConversorMoneda.conversor("USD","ARS",consultar, lectura);
                        break;
                    case 2:
                        ConversorMoneda.conversor("ARS","USD",consultar,lectura);
                        break;
                    case 3:
                        ConversorMoneda.conversor("USD","BRL",consultar,lectura);
                        break;
                    case 4:
                        ConversorMoneda.conversor("BRL","USD",consultar, lectura);
                        break;
                    case 5:
                        ConversorMoneda.conversor("USD","COP",consultar, lectura);
                        break;
                    case 6:
                        ConversorMoneda.conversor("COP","USD",consultar, lectura);
                        break;
                    case 7:
                        ConversorMoneda.conversarOtraMoneda(consultar,lectura);
                        break;
                    case 8:
                        System.out.println("Saliendo del programa.........");
                        break;

                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor,Ingrese un número del 1 al 8.");
                lectura.nextLine();
                opcion = 0;
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                opcion = 0;
            }
            System.out.println("\nPresiona Enter para continuar......");
            lectura.nextLine();
        }
        lectura.close();
    }
}
