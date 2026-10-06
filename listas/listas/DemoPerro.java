package mx.unam.aragon.ico.edd.listas;

public class DemoPerro {
    public static void main(String[] args) {
        ListaLigadaADT<Perro> lista = new ListaLigadaADT<>();

        Perro firulais = new Perro("Firulais", "Labrador", 5);
        Perro rex = new Perro("Rex", "Pastor Aleman", 3);
        Perro luna = new Perro("Luna", "Husky", 2);
        Perro toby = new Perro("Toby", "Chihuahua", 7);
        Perro max = new Perro("Max", "Beagle", 4);

        System.out.println("¿Vacia? " + lista.estaVacia());
        lista.transversal();

        System.out.println("\n-agregar (firulais) / agregarAlFinal (rex)");
        lista.agregar(firulais);
        lista.agregarAlFinal(rex);
        lista.transversal();

        System.out.println("\n-agregarAlInicio (luna)");
        lista.agregarAlInicio(luna);
        lista.transversal();

        System.out.println("\n-agregarDespuesDe(Rex, Toby)");
        lista.agregarDespuesDe(rex, toby);
        lista.transversal();
        System.out.println("Tamaño: " + lista.getTamanio());

        System.out.println("\n-buscar (Rex / Max)");
        System.out.println("Posicion de Rex: " + lista.buscar(rex));
        System.out.println("Posicion de Max (no esta): " + lista.buscar(max));

        System.out.println("\n-actualizar(Firulais -> Max)");
        lista.actualizar(firulais, max);
        lista.transversal();

        System.out.println("\n-eliminarElPrimero (Luna)");
        lista.eliminarElPrimero();
        lista.transversal();

        System.out.println("\n-eliminarElFinal (Toby)");
        lista.eliminarElFinal();
        lista.transversal();
        System.out.println("Tamaño: " + lista.getTamanio());
        System.out.println("¿Vacia? " + lista.estaVacia());

        System.out.println("\n-vaciar la lista");
        lista.eliminarElFinal();
        lista.eliminarElFinal();
        lista.transversal();
        System.out.println("¿Vacia? " + lista.estaVacia());
    }
}
