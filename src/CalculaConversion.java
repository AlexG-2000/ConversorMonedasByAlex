import java.util.Scanner;

public class CalculaConversion {
    private final ConsultaAPI conversion;

    public CalculaConversion(ConsultaAPI conversion) {
        this.conversion = conversion;
    }

    public String obtenerMensajeRespuesta(String monedaBase, String monedaObjetivo, double cantidad) {
        double resultado = conversion.buscaConversion(monedaBase, monedaObjetivo, cantidad);
        String mensaje = String.format("%s %.2f equivale a %s %.2f",
                monedaBase.toUpperCase(), cantidad, monedaObjetivo.toUpperCase(), resultado);
        return mensaje;
    }
}

