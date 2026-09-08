import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    private static final int RENGLONES = 10;
    private static final int COLUMNAS = 10;
    private static final int GENERACIONES = 10;

    public static void main(String[] args) {

        String rutaArchivo = (args.length > 0) ? args[0] : encontrarCSV();

        JuegoDeLaVida juego = new JuegoDeLaVida(RENGLONES, COLUMNAS);

        try {
            juego.cargarDesdeCSV(rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo '" + rutaArchivo + "': " + e.getMessage());
            return;
        }

        System.out.println("=== JUEGO DE LA VIDA ===");
        System.out.println("Tablero: " + juego.getRenglones() + "x" + juego.getColumnas());
        System.out.println("Generaciones a calcular: " + GENERACIONES);
        System.out.println();


        juego.imprimir(0);


        for (int gen = 1; gen <= GENERACIONES; gen++) {
            juego.calcularSiguienteGeneracion();
            juego.imprimir(gen);
        }
    }

    private static String encontrarCSV() {
        Path rutaLocal = Path.of("poblacion_inicial.csv");
        if (Files.exists(rutaLocal)) {
            return rutaLocal.toString();
        }

        Path rutaProyectoAnidado = Path.of("JuegoDeLaVida", "poblacion_inicial.csv");
        return rutaProyectoAnidado.toString();
    }
}
