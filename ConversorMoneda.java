import java.util.Scanner;

public class ConversorMoneda {

    public static void conversor (String monedabase,
                                  String monedaTarget,
                                  ConsultarMonedasDeCambio consultar,
                                  Scanner lectura) {
        double cantidad;

        try {
            Moneda monedas = consultar.buscarMonedas(monedabase, monedaTarget);
            System.out.println("La tasa de conversion para hoy:");
            System.out.printf("1 %s = %.4f %s%n", monedabase, monedas.conversion_rate(), monedaTarget);

            System.out.println("Ingrese la cantidad " + monedabase + " a convertir:");
            cantidad = Double.parseDouble(lectura.nextLine());

            double cantidadConvertida = cantidad + monedas.conversion_rate();
            System.out.printf("%s.2f %s equivale a %.2f %s%n", cantidad, monedabase, cantidadConvertida, monedaTarget);
        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor, ingrese un número válido para la cantidad.");
        } catch (RuntimeException e) {
            System.out.println("Error en la conversion:" + e.getMessage());
        }
    }
    public  static void  conversarOtraMoneda(ConsultarMonedasDeCambio consultar,
                                             Scanner lectura){
        System.out.println("Ingrese la abreviatura de la moneda base: ");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese la moneda objetivo: ");
        String monedaObjetivo = lectura.nextLine().toUpperCase();
        conversor(monedaBase,monedaObjetivo,consultar,lectura);
    }

}
