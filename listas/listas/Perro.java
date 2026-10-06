package mx.unam.aragon.ico.edd.listas;

public class Perro {
    private String nombre;
    private String raza;
    private int edad;

    public Perro(String nombre, String raza, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public String getRaza() { return raza; }
    public int getEdad() { return edad; }

    @Override
    public String toString() {
        return nombre + " (" + raza + ", " + edad + " años)";
    }
}
