import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class JuegoDeLaVida {

    private static final Integer VIVA = 1;
    private static final Integer MUERTA = 0;

    private Array2D<Integer> tablero;
    private int renglones;
    private int columnas;

    public JuegoDeLaVida(int renglones, int columnas) {
        this.renglones = renglones;
        this.columnas = columnas;
        this.tablero = new Array2D<>(renglones, columnas);
        this.tablero.rellenar(MUERTA);
    }


    public void cargarDesdeCSV(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int ren = 0;
            while ((linea = br.readLine()) != null && ren < renglones) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                String[] valores = linea.split(",");
                for (int col = 0; col < columnas && col < valores.length; col++) {
                    int valor = Integer.parseInt(valores[col].trim());
                    tablero.establecerElemento(ren, col, valor == 1 ? VIVA : MUERTA);
                }
                ren++;
            }
        }
    }


    private int contarVecinosVivos(int ren, int col) {
        int contador = 0;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                int nr = ren + dr;
                int nc = col + dc;
                if (nr >= 0 && nr < renglones && nc >= 0 && nc < columnas) {
                    if (tablero.obtenerElemento(nr, nc) == VIVA) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }


    public void calcularSiguienteGeneracion() {
        Array2D<Integer> nuevoTablero = new Array2D<>(renglones, columnas);

        for (int ren = 0; ren < renglones; ren++) {
            for (int col = 0; col < columnas; col++) {
                int vecinosVivos = contarVecinosVivos(ren, col);
                int estadoActual = tablero.obtenerElemento(ren, col);
                int nuevoEstado;

                if (estadoActual == VIVA) {
                    if (vecinosVivos == 2 || vecinosVivos == 3) {
                        nuevoEstado = VIVA; 
                    } else if (vecinosVivos <= 1) {
                        nuevoEstado = MUERTA; 
                    } else {
                        nuevoEstado = MUERTA; 
                    }
                } else {
                    if (vecinosVivos == 3) {
                        nuevoEstado = VIVA; 
                    } else {
                        nuevoEstado = MUERTA; 
                    }
                }

                nuevoTablero.establecerElemento(ren, col, nuevoEstado);
            }
        }

        this.tablero = nuevoTablero;
    }


    public void imprimir(int numeroGeneracion) {
        System.out.println("--- Generación " + numeroGeneracion + " ---");
        for (int ren = 0; ren < renglones; ren++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < columnas; col++) {
                int valor = tablero.obtenerElemento(ren, col);
                sb.append(valor == VIVA ? "■ " : "· ");
            }
            System.out.println(sb.toString());
        }
        System.out.println();
    }


    public String estadoCrudo() {
        return tablero.toString();
    }

    public int getRenglones() {
        return renglones;
    }

    public int getColumnas() {
        return columnas;
    }
}
