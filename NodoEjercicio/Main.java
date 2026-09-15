public class Main {
    public static void main(String[] args) {
        //1.
        Nodo<String> head = new Nodo<>("Al", new Nodo<>("B", new Nodo<>("C", new Nodo<>("De", new Nodo<>("Mc", new Nodo<>("Zi"))))));
        
        //2.
        System.out.println(head +"\n");
        
        //3.
        System.out.println(head.getDato() +"\n");
        
        //4.
        System.out.println(head.getSiguiente().getSiguiente().getSiguiente().getSiguiente().getSiguiente().toString() +"\n");
        
        //5.
        String ref = "De";
        Nodo<String> cursor = head;
        while (cursor.getDato() != ref){
            cursor = cursor.getSiguiente();
        }
        if (cursor != null) {
            cursor.setSiguiente(new Nodo<>("Fe", cursor.getSiguiente()));
        }
        //6.
        System.out.println(head +"\n");

        //7.
        String ref2 = "Zi";
        Nodo<String> cursor2 = head;
        while (cursor2.getDato() != ref2){
            cursor2 = cursor2.getSiguiente();
        }
        if (cursor2 != null) {
            cursor2.setSiguiente(new Nodo<>("Zz"));
        }

        //8.
        System.out.println(head +"\n");

        //9.
        head = new Nodo("Aa", head.getSiguiente());

        //10.
        System.out.println(head +"\n");
    }
}