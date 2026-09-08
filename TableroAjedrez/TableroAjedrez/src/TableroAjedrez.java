public class TableroAjedrez {

    // Piezas negras (Unicode)
    private static final char TORRE_N   = '\u265C'; // ♜
    private static final char CABALLO_N = '\u265E'; // ♞
    private static final char ALFIL_N   = '\u265D'; // ♝
    private static final char REINA_N   = '\u265B'; // ♛
    private static final char REY_N     = '\u265A'; // ♚
    private static final char PEON_N    = '\u265F'; // ♟

    // Piezas blancas (Unicode)
    private static final char TORRE_B   = '\u2656'; // ♖
    private static final char CABALLO_B = '\u2658'; // ♘
    private static final char ALFIL_B   = '\u2657'; // ♗
    private static final char REINA_B   = '\u2655'; // ♕
    private static final char REY_B     = '\u2654'; // ♔
    private static final char PEON_B    = '\u2659'; // ♙

    private static final char VACIA = ' ';

    private Array2D<Character> tablero;

    public TableroAjedrez() {
        tablero = new Array2D<>(8, 8);
        tablero.rellenar(VACIA);
        colocarPosicionInicial();
    }

    private void colocarPosicionInicial() {

        char[] filaMayorNegra = {TORRE_N, CABALLO_N, ALFIL_N, REINA_N, REY_N, ALFIL_N, CABALLO_N, TORRE_N};

        char[] filaMayorBlanca = {TORRE_B, CABALLO_B, ALFIL_B, REINA_B, REY_B, ALFIL_B, CABALLO_B, TORRE_B};

        for (int col = 0; col < 8; col++) {
            tablero.establecerElemento(0, col, filaMayorNegra[col]); // fila 8
            tablero.establecerElemento(1, col, PEON_N);              // fila 7
            tablero.establecerElemento(6, col, PEON_B);              // fila 2
            tablero.establecerElemento(7, col, filaMayorBlanca[col]);// fila 1
        }
    }


    public void imprimir() {

        for (int ren = 0; ren < tablero.obtenerRenglones(); ren++) {
            int numeroFila = 8 - ren; // renglón 0 -> fila 8, renglón 7 -> fila 1
            System.out.print(numeroFila);
            for (int col = 0; col < tablero.obtenerColumnas(); col++) {
                System.out.print(" " + tablero.obtenerElemento(ren, col) + " ");
            }
            System.out.println();
        }

    }


    public String estadoCrudo() {
        return tablero.toString();
    }
}
