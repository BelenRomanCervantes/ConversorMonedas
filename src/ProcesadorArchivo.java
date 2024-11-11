import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProcesadorArchivo {

    public static void guardarHistorial(String base_code, String target_code, double conversion_rate, double cantidad, double conversion_result) {
        String fileName = "historial.txt";
        LocalDateTime fechaHora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String registro = String.format("Fecha y hora: %s, Base: %s, Destino: %s, Tipo de cambio: %.4f, Cantidad: %.2f, Resultado: %.2f%n",
                fechaHora.format(formatter), base_code, target_code, cantidad, conversion_rate, conversion_result);
        try (FileWriter escritura = new FileWriter(fileName, true)){
            escritura.write(registro);
        } catch (IOException e){
            System.out.println("Error al guardar registro");
        }

    }

    public static void mostrarHistorial() {
        String fileName = "historial.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            System.out.println("**** Historial de Conversiones ****");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el historial de conversiones.");
        }
    }
}
