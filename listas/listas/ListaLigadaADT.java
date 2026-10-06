package mx.unam.aragon.ico.edd.listas;

public class ListaLigadaADT<T> {
    private Nodo<T> head;
 
    public ListaLigadaADT() {
        this.head = null;
    }

    public boolean estaVacia() {
        return head == null;
    }

    public int getTamanio() {
        int contador = 0;
        Nodo<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    public void agregar(T dato) {
        agregarAlFinal(dato);
    }

    public void agregarAlFinal(T dato) {
        if (estaVacia()) {
            this.head = new Nodo<>(dato);
        } else {
            Nodo<T> actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(new Nodo<>(dato));
        }
    }

    public void agregarAlInicio(T dato) {
        this.head = new Nodo<>(dato, head);
    }

    public void agregarDespuesDe(T referencia, T valor) {
        if (estaVacia()) {
            System.out.println("Vacia");
            return;
        }
        Nodo<T> actual = this.head;
        while (actual != null && !actual.getDato().equals(referencia)) {
            actual = actual.getSiguiente();
        }
        if (actual == null) {
            System.out.println("No se encontro la referencia: " + referencia);
            return;
        }
        actual.setSiguiente(new Nodo<>(valor, actual.getSiguiente()));
    }

    public void eliminarElPrimero() {
        if (estaVacia()) {
            System.out.println("Vacia");
        } else {
            head = head.getSiguiente();
        }
    }

    public void eliminarElFinal() {
        if (estaVacia()) {
            System.out.println("Vacia");
        } else if (head.getSiguiente() == null) {
            head = null;
        } else {
            Nodo<T> actual = head;
            while (actual.getSiguiente().getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(null);
        }
    }

    //empezando en 0, -1 si no existe
    public int buscar(T valor) {
        Nodo<T> actual = head;
        int posicion = 0;
        while (actual != null) {
            if (actual.getDato().equals(valor)) {
                return posicion;
            }
            actual = actual.getSiguiente();
            posicion++;
        }
        return -1;
    }

    public void actualizar(T aBuscar, T nuevoValor) {
        if (estaVacia()) {
            System.out.println("Vacia");
            return;
        }
        Nodo<T> actual = this.head;
        while (actual != null && !actual.getDato().equals(aBuscar)) {
            actual = actual.getSiguiente();
        }
        if (actual == null) {
            System.out.println("No se encontro: " + aBuscar);
        } else {
            actual.setDato(nuevoValor);
        }
    }

    public void transversal() {
        if (estaVacia()) {
            System.out.println("Vacia");
        } else {
            Nodo<T> actual = head;
            while (actual != null) {
                System.out.print("|" + actual.getDato());
                actual = actual.getSiguiente();
            }
            System.out.println("|");
        }
    }
}
