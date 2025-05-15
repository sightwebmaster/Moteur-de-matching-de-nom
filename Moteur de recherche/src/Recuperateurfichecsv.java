import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Recuperateurfichecsv implements Recuperateur {

    private String filePath;

    // Constructeur qui initialise le chemin du fichier CSV
    public Recuperateurfichecsv(String filePath) {
        this.filePath = filePath;
    }

    // Méthode qui lit le fichier CSV et retourne une liste d’objets ListeDesNoms
    @Override
    public List<CoupleDeString> recuperer() {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines
                    .skip(1) // Ignore la première ligne (en-tête)
                    .map(line -> line.split(",")) // Sépare chaque ligne CSV en tableau
                    .filter(values -> values.length >= 2) // Ignore les lignes incomplètes
                    .map(values -> new CoupleDeString(values[0].trim(), values[1].trim())) // Crée les objets ListeDesNoms
                    .collect(Collectors.toList()); // Convertit le Stream en List (compatible Java 11)
        } catch (IOException e) {
            e.printStackTrace();
            return List.of(); // Retourne une liste vide en cas d’erreur
        }
    }
}
