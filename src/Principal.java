import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaAPI consulta = new ConsultaAPI();
        CalculaConversion calcula = new CalculaConversion(consulta);
        GeneraArchivos generador = new GeneraArchivos();

        List<String> historial = new ArrayList<>();

        Map<Integer, String[]> opciones = Map.of(
                1, new String[]{"ARS", "USD"},
                2, new String[]{"ARS", "EUR"},
                3, new String[]{"ARS", "BRL"},
                4, new String[]{"USD", "ARS"},
                5, new String[]{"EUR", "ARS"},
                6, new String[]{"BRL", "ARS"}
        );

        String menu = """
                \n***************************************************
                *** Sea bienvenido al Conversor de Monedas ***

                1) Peso Argentino -> Dólar Estadounidense
                2) Peso Argentino -> Euro
                3) Peso Argentino -> Real Brasileño
                4) Dólar Estadounidense -> Peso Argentino
                5) Euro -> Peso Argentino
                6) Real Brasileño -> Peso Argentino

                7) Otra opción de conversión
                8) Salir
                ***************************************************
                """;

        int opcion = 0;
        while (true) {
            try {
                System.out.println(menu);
                opcion = Integer.parseInt(lectura.nextLine());

                if (opcion == 8) break;

                String monedaBase, monedaObjetivo;
                double cantidad;

                if (opcion >= 1 && opcion <= 6) {
                    String[] monedas = opciones.get(opcion);
                    monedaBase = monedas[0];
                    monedaObjetivo = monedas[1];
                    System.out.println("Ingrese el valor que deseas convertir:");
                    cantidad = Double.parseDouble(lectura.nextLine());
                } else if (opcion == 7) {
                    System.out.println("Ingrese la moneda base (ej: USD):");
                    monedaBase = lectura.nextLine().trim();
                    System.out.println("Ingrese la moneda objetivo (ej: EUR):");
                    monedaObjetivo = lectura.nextLine().trim();
                    System.out.println("Ingrese el valor que deseas convertir:");
                    cantidad = Double.parseDouble(lectura.nextLine());
                } else {
                    System.out.println("Opción no válida.");
                    continue;
                }

                String timestamp = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

                String mensaje = calcula.obtenerMensajeRespuesta(monedaBase, monedaObjetivo, cantidad);
                System.out.println(mensaje);

                historial.add(timestamp + " - " + mensaje);

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            } catch (RuntimeException e) {
                System.out.println("Error durante la conversión: " + e.getMessage());
            }
        }

        // Guardar historial al final
        generador.guardarHistorial(historial);
        System.out.println("Finalizando programa.");
    }
}
