import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        int opcion = 0;
        String base = "";
        String target = "";
        double cantidad = 0;
        String menu = """
                *************************************************************
                Sea bienvenido/a al Conversor de Moneda =)
                
                Elija una de las siguientes opciones:                
                1) Dólar           =>>   Peso argentino
                2) Peso argentino  =>>   Dólar
                3) Dólar           =>>   Real brasileño
                4) Real brasileño  =>>   Dólar
                5) Dólar           =>>   Peso colombiano
                6) Peso colombiano =>>   Dólar
                7) Dólar           =>>   Peso mexicano
                8) Peso mexicano   =>>   Dólar
                9) Historial
                10) Salir
                ************************************************************
                """;

        ConsultarMoneda consulta = new ConsultarMoneda();

        Scanner scanner = new Scanner(System.in);
        while (opcion != 10) {
            System.out.println(menu);
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    base = "USD";
                    target = "ARS";
                    break;
                case 2:
                    base = "ARS";
                    target = "USD";
                    break;
                case 3:
                    base = "USD";
                    target = "BRL";
                    break;
                case 4:
                    base = "BRL";
                    target = "USD";
                    break;
                case 5:
                    base = "USD";
                    target = "COP";
                    break;
                case 6:
                    base = "COP";
                    target = "USD";
                    break;
                case 7:
                    base = "USD";
                    target = "MXN";
                    break;
                case 8:
                    base = "MXN";
                    target = "USD";
                    break;
                case 9:
                    ProcesadorArchivo.mostrarHistorial();
                    break;
                case 10:
                    System.out.println("Sistema finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

            if (opcion < 9) {
                System.out.println("Ingrese la cantidad que desea convertir: ");
                cantidad = scanner.nextDouble();

                Moneda moneda = consulta.consultarMoneda(base, target, cantidad);
                System.out.println("Resultado: " + moneda.conversion_result());

                ProcesadorArchivo.guardarHistorial(base, target, cantidad, moneda.conversion_rate(), moneda.conversion_result());
            }
        }

    }
}
