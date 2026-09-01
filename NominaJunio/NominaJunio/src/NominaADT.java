import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ADT construido a partir de ArrayADT<Trabajador>.
 * Almacena la información de los trabajadores leída de un archivo .dat
 * y ofrece las operaciones de negocio requeridas.
 */
public class NominaADT {

    private ArrayADT<Trabajador> trabajadores;
    private int cantidad; // número de registros realmente cargados

    public NominaADT(int capacidad) {
        this.trabajadores = new ArrayADT<>(capacidad);
        this.cantidad = 0;
    }

    /**
     * Carga los datos desde el archivo .dat (formato CSV, primera línea = encabezado).
     */
    public void cargarDesdeArchivo(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine(); // descartar encabezado
            int indice = 0;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                String[] campos = linea.split(",");
                if (campos.length < 7) continue;

                int numero = Integer.parseInt(campos[0].trim());
                String nombres = campos[1].trim();
                String paterno = campos[2].trim();
                String materno = campos[3].trim();
                int horasExtra = Integer.parseInt(campos[4].trim());
                double sueldoBase = Double.parseDouble(campos[5].trim());
                int anioIngreso = Integer.parseInt(campos[6].trim());

                Trabajador t = new Trabajador(numero, nombres, paterno, materno,
                        horasExtra, sueldoBase, anioIngreso);

                trabajadores.insertarElemento(indice, t);
                indice++;
            }
            this.cantidad = indice;
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public Trabajador obtener(int indice) {
        return trabajadores.obtenerElemento(indice);
    }

    /**
     * Devuelve el trabajador con MAYOR antigüedad.
     */
    public Trabajador trabajadorMayorAntiguedad() {
        Trabajador mayor = trabajadores.obtenerElemento(0);
        for (int i = 1; i < cantidad; i++) {
            Trabajador actual = trabajadores.obtenerElemento(i);
            if (actual.getAntiguedad() > mayor.getAntiguedad()) {
                mayor = actual;
            }
        }
        return mayor;
    }

    /**
     * Devuelve el trabajador con MENOR antigüedad.
     */
    public Trabajador trabajadorMenorAntiguedad() {
        Trabajador menor = trabajadores.obtenerElemento(0);
        for (int i = 1; i < cantidad; i++) {
            Trabajador actual = trabajadores.obtenerElemento(i);
            if (actual.getAntiguedad() < menor.getAntiguedad()) {
                menor = actual;
            }
        }
        return menor;
    }

    /**
     * Despliega todos los datos de todos los empleados, incluyendo el sueldo a pagar.
     */
    public void mostrarTodos() {
        System.out.println("=====================================================================================================================");
        System.out.println("                                          NÓMINA DE TRABAJADORES - JUNIO");
        System.out.println("=====================================================================================================================");
        for (int i = 0; i < cantidad; i++) {
            System.out.println(trabajadores.obtenerElemento(i));
        }
        System.out.println("=====================================================================================================================");
    }
}
