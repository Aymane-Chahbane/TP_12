package exercice_1;
import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		try {
			// Exo 1 : lecture
			System.out.println("=== Lecture input.txt ===");
			TextReader.readLines("input.txt");

			// Exo 2 : copie + résumé
			System.out.println("\n=== Copie avec résumé ===");
			TextWriter.copyWithSummary("input.txt", "output.txt");

			// Exo 3 : CSV
			System.out.println("\n=== CSV passed ===");
			List<Record> all = CsvParser.readCsv("data.csv");
			List<Record> passed = all.stream().filter(r -> r.getScore() >= 50).toList();
			CsvParser.writeCsv(passed, "passed.csv");
			System.out.println("Fichier passed.csv généré avec succès.");
			// Exo 4 : sérialisation
			ObjectSerializer.serialize(all, "records.ser");
			List<Record> loaded = ObjectSerializer.deserialize("records.ser");
			System.out.println("\n=== Objets désérialisés ===");
			loaded.forEach(System.out::println);

		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Erreur : " + e.getMessage());
		}
	}
}