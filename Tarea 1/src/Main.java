import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        String[] meses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO"};

        int twSeguidoresEnero = 62404;   
        int twSeguidoresJunio = 67496;   

        int[] ytVisualizaciones = {12226, 15605, 19602, 19452, 21805, 17344}; 
        int[] fbCrecimiento = {660, 485, 3638, 4585, 5308, 7925};            
        int[] twCrecimiento = {863, 828, 917, 1261, 945, 1141};             

        int[] fbMeGusta = {8771, 9002, 13556, 15022, 38953, 16487};           
        int[] twMeGusta = {1224, 1225, 1601, 1994, 2667, 2069};               
        int[] ytMeGusta = {4, 15, 15, 8, 30, 33};                            

        int difTwitterSeguidores = twSeguidoresJunio - twSeguidoresEnero;
        System.out.println("1. Diferencia de seguidores en Twitter (Enero vs Junio): " + difTwitterSeguidores);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCalculo de diferencia de visualizaciones de YouTube");
        System.out.println("Opciones de mes: 0-ENERO, 1-FEBRERO, 2-MARZO, 3-ABRIL, 4-MAYO, 5-JUNIO");

        System.out.print("Ingrese el numero del primer mes (0 a 5): ");
        int mes1 = scanner.nextInt();
        System.out.print("Ingrese el numero del segundo mes (0 a 5): ");
        int mes2 = scanner.nextInt();

        if (mes1 >= 0 && mes1 <= 5 && mes2 >= 0 && mes2 <= 5) {
            int difYT = Math.abs(ytVisualizaciones[mes2] - ytVisualizaciones[mes1]);
            System.out.println("\n2. Diferencia de visualizaciones entre " + meses[mes1] + " y " + meses[mes2] + ": " + difYT);
        } else {
            System.out.println("Numero de mes invalido.");
        }

        
        double sumaFbCrec = 0;
        double sumaTwCrec = 0;

        for (int i = 0; i < 6; i++) {
            sumaFbCrec += fbCrecimiento[i];
            sumaTwCrec += twCrecimiento[i];
        }

        double promFbCrec = sumaFbCrec / 6.0;
        double promTwCrec = sumaTwCrec / 6.0;

        System.out.println("\n3. Promedio de crecimiento mensual (Enero - Junio):");
        System.out.println("   - Facebook: " + promFbCrec);
        System.out.println("   - Twitter:  " + promTwCrec);


        double sumaFbLikes = 0;
        double sumaTwLikes = 0;
        double sumaYtLikes = 0;

        for (int i = 0; i < 6; i++) {
            sumaFbLikes += fbMeGusta[i];
            sumaTwLikes += twMeGusta[i];
            sumaYtLikes += ytMeGusta[i];
        }

        double promFbLikes = sumaFbLikes / 6.0;
        double promTwLikes = sumaTwLikes / 6.0;
        double promYtLikes = sumaYtLikes / 6.0;

        System.out.println("\n4. Promedio de 'Me gusta' mensuales (Enero - Junio):");
        System.out.println("   - Facebook: " + promFbLikes);
        System.out.println("   - Twitter:  " + promTwLikes);
        System.out.println("   - YouTube:  " + promYtLikes);

        scanner.close();
    }
}
