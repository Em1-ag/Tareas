import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String rutaArchivo = "../junio.dat";
        int capacidadMaxima = 100; // capacidad suficiente para los registros del archivo

        NominaADT nomina = new NominaADT(capacidadMaxima);

        try {
            nomina.cargarDesdeArchivo(rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo '" + rutaArchivo + "': " + e.getMessage());
            return;
        }

        System.out.println("Total de trabajadores cargados: " + nomina.getCantidad());
        System.out.println();

        // Trabajador con mayor y menor antigüedad
        Trabajador mayorAntiguedad = nomina.trabajadorMayorAntiguedad();
        Trabajador menorAntiguedad = nomina.trabajadorMenorAntiguedad();

        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println("TRABAJADOR CON MAYOR ANTIGÜEDAD:");
        System.out.println(mayorAntiguedad);
        System.out.println();
        System.out.println("TRABAJADOR CON MENOR ANTIGÜEDAD:");
        System.out.println(menorAntiguedad);
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println();

        // Todos los empleados con su sueldo a pagar
        nomina.mostrarTodos();
    }
}
