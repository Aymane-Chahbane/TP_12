package exercice_1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParser {
	public static List<Record> readCsv(String path) throws IOException {
		 return Files.lines(Paths.get(path))
	                .skip(1) // ignorer l'en-tête
	                .map(line -> line.split(","))
	                .map(cols -> new Record(
	                        Integer.parseInt(cols[0]),
	                        cols[1],
	                        Double.parseDouble(cols[2])
	                ))
	                .collect(Collectors.toList());
	}

	public static void writeCsv(List<Record> records, String path) throws IOException {
		 try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
	            writer.write("id,name,score");
	            writer.newLine();

	            for (Record r : records) {
	                writer.write(r.getId() + "," + r.getName() + "," + r.getScore());
	                writer.newLine();
	            }
	        }
	}
}

