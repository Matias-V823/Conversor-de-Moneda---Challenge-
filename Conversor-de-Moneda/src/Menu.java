import java.util.Scanner;

public class Menu {

    public void opcionesMenu(int opcion) {
        var json = new ConsumoAPI();
        ConversionRates usdData = json.obtenerDatos("USD");
        ConversionRates arsData = json.obtenerDatos("ARS");
        ConversionRates brlData = json.obtenerDatos("BRL");
        ConversionRates copData = json.obtenerDatos("COP");

        double usdConvArs = usdData.getConversionRates().get("ARS");
        double arsConvUsd = 1 / usdConvArs;
        double usdConvBrl = usdData.getConversionRates().get("BRL");
        double brlConvUsd = 1 / usdConvBrl;
        double usdConvCop = usdData.getConversionRates().get("COP");
        double copConvUsd = 1 / usdConvCop;

        Scanner scanner = new Scanner(System.in);
        switch (opcion) {
            case 1:
                System.out.println("Ingrese cantidad en Dólares:");
                double cantidadUsdConvArs = scanner.nextDouble();
                System.out.println(cantidadUsdConvArs + " USD = " + (cantidadUsdConvArs * usdConvArs) + " ARS");
                break;
            case 2:
                System.out.println("Ingrese cantidad en Pesos Argentinos:");
                double cantidadArsConvUsd = scanner.nextDouble();
                System.out.println(cantidadArsConvUsd + " ARS = " + (cantidadArsConvUsd * arsConvUsd) + " USD");
                break;
            case 3:
                System.out.println("Ingrese cantidad en Dólares:");
                double cantidadUsdConvBrl = scanner.nextDouble();
                System.out.println(cantidadUsdConvBrl + " USD = " + (cantidadUsdConvBrl * usdConvBrl) + " BRL");
                break;
            case 4:
                System.out.println("Ingrese cantidad en Reales Brasileños:");
                double cantidadBrlConvUsd = scanner.nextDouble();
                System.out.println(cantidadBrlConvUsd + " BRL = " + (cantidadBrlConvUsd * brlConvUsd) + " USD");
                break;
            case 5:
                System.out.println("Ingrese cantidad en Dólares:");
                double cantidadUsdConvCop = scanner.nextDouble();
                System.out.println(cantidadUsdConvCop + " USD = " + (cantidadUsdConvCop * usdConvCop) + " COP");
                break;
            case 6:
                System.out.println("Ingrese cantidad en Pesos Colombianos:");
                double cantidadCopConvUsd = scanner.nextDouble();
                System.out.println(cantidadCopConvUsd + " COP = " + (cantidadCopConvUsd * copConvUsd) + " USD");
                break;
            case 7:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
