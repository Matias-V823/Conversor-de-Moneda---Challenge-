import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        var menu = new Menu();
        Scanner teclado = new Scanner(System.in);
        int opcionSeleccionada = 0;

        while (opcionSeleccionada != 7) {
            var texto = """
                        \s
            Sea bienvenido/a al Conversor de Moneda
            Seleccione la opción que desea realizar:
                        \s
            1) Dólar --> Peso Argentino
            2) Peso argentino --> Dólar
            3) Dólar --> Real Brasileño
            4) Real Brasileño --> Dólar
            5) Dólar --> Peso colombiano
            6) Peso colombiano --> Dólar
            7) Salir
                        \s
                        \s
            \s""";
            System.out.println(texto);
            opcionSeleccionada = teclado.nextInt();
            menu.opcionesMenu(opcionSeleccionada);
        }
        teclado.close();
    }
}
