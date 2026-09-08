public class Array2D<T> {

    private int renglones;
    private int columnas;
    private Object[] datos;

    public Array2D(int ren, int col) {
        this.renglones = ren;
        this.columnas = col;
        this.datos = new Object[ren * col];
    }


    public void rellenar(T dato) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = dato;
        }
    }


    public int obtenerRenglones() {
        return renglones;
    }


    public int obtenerColumnas() {
        return columnas;
    }


    public void establecerElemento(int ren, int col, T dato) {
        if (indiceValido(ren, col)) {
            datos[ren * columnas + col] = dato;
        } else {
            System.out.println("Indice fuera de rango: (" + ren + "," + col + ")");
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    @SuppressWarnings("unchecked")
    public T obtenerElemento(int ren, int col) {
        if (indiceValido(ren, col)) {
            return (T) datos[ren * columnas + col];
        } else {
            System.out.println("Indice fuera de rango: (" + ren + "," + col + ")");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private boolean indiceValido(int ren, int col) {
        return ren >= 0 && ren < renglones && col >= 0 && col < columnas;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < renglones; r++) {
            sb.append("[");
            for (int c = 0; c < columnas; c++) {
                sb.append(datos[r * columnas + c]);
                if (c < columnas - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (r < renglones - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
