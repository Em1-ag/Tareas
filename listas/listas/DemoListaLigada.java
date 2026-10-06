package mx.unam.aragon.ico.edd.listas;

public class DemoListaLigada {
    public static void main(String[] args) {
        ListaLigadaADT<String> lista = new ListaLigadaADT<>();
        lista.transversal();
        lista.agregar("Diego");
        //lista.transversal();
        lista.agregar("Diana");
        lista.agregar("Toñito");
        lista.transversal();
        lista.actualizar("Diana", "Maria");
        System.out.println("-----");
        lista.transversal();
        System.out.println("\nTamaño: " + lista.getTamanio());
        lista.agregar("Jesus");
        lista.transversal();
        System.out.println("\nTamaño: " + lista.getTamanio());
        System.out.println("------------");
        lista.agregarDespuesDe("Toñito","Kevin");
        lista.transversal();

    }

}
