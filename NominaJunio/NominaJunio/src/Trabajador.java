/**
 * Representa un registro de trabajador leído desde junio.dat
 * numero de trabajador, nombres, paterno, materno, horas extra, sueldo base, año de ingreso
 */
public class Trabajador {

    public static final double COSTO_HORA_EXTRA = 276.5;
    public static final double PORCENTAJE_ANTIGUEDAD = 0.03; // 3% por año

    private int numero;
    private String nombres;
    private String paterno;
    private String materno;
    private int horasExtra;
    private double sueldoBase;
    private int anioIngreso;

    public Trabajador(int numero, String nombres, String paterno, String materno,
                       int horasExtra, double sueldoBase, int anioIngreso) {
        this.numero = numero;
        this.nombres = nombres;
        this.paterno = paterno;
        this.materno = materno;
        this.horasExtra = horasExtra;
        this.sueldoBase = sueldoBase;
        this.anioIngreso = anioIngreso;
    }

    // ---------- Getters ----------
    public int getNumero() { return numero; }
    public String getNombres() { return nombres; }
    public String getPaterno() { return paterno; }
    public String getMaterno() { return materno; }
    public int getHorasExtra() { return horasExtra; }
    public double getSueldoBase() { return sueldoBase; }
    public int getAnioIngreso() { return anioIngreso; }

    /**
     * Antigüedad en años completos, calculada respecto al año actual del sistema.
     */
    public int getAntiguedad() {
        int anioActual = java.time.Year.now().getValue();
        int antiguedad = anioActual - anioIngreso;
        return Math.max(antiguedad, 0);
    }

    /**
     * Pago por horas extra: horas extra * $276.5
     */
    public double getPagoHorasExtra() {
        return horasExtra * COSTO_HORA_EXTRA;
    }

    /**
     * Prestación por antigüedad: 3% del sueldo base por cada año de antigüedad.
     */
    public double getPrestacionAntiguedad() {
        return sueldoBase * PORCENTAJE_ANTIGUEDAD * getAntiguedad();
    }

    /**
     * Sueldo total a pagar en el mes:
     * sueldo base + pago de horas extra + prestación por antigüedad
     */
    public double getSueldoAPagar() {
        return sueldoBase + getPagoHorasExtra() + getPrestacionAntiguedad();
    }

    public String getNombreCompleto() {
        return nombres + " " + paterno + " " + materno;
    }

    @Override
    public String toString() {
        return String.format(
            "No: %-6d | %-30s | H.Extra: %-3d | S.Base: $%-10.2f | Año Ingreso: %-5d | Antigüedad: %-3d años | Sueldo a pagar: $%.2f",
            numero, getNombreCompleto(), horasExtra, sueldoBase, anioIngreso, getAntiguedad(), getSueldoAPagar()
        );
    }
}
