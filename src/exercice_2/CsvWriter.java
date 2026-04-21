package exercice_2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;


public class CsvWriter {

   
    public static void writeCsv(String path, List<String> header, List<String[]> rows) {
        try (PrintWriter pw = new PrintWriter(path)) {
            // Écrire l'en-tête
            pw.println(String.join(",", header));
            // Écrire chaque ligne de données
            for (String[] row : rows) {
                pw.println(String.join(",", row));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Impossible d’écrire le CSV : " + e.getMessage());
        }
    }
}
