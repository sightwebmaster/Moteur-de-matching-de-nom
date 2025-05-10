import org.apache.commons.text.similarity.LevenshteinDistance;

public class ComparateurAvecLevenshtein implements ComparateurDeChaine {

    @Override
    public double comparer(String nom1, String nom2) {
        LevenshteinDistance ld = new LevenshteinDistance(Integer.MAX_VALUE);
        int distance = ld.apply(nom1, nom2);

        int maxLength = Math.max(nom1.length(), nom2.length());
        double score = (maxLength == 0) ? 1.0 : 1.0 - ((double) distance / maxLength);

        System.out.println("Score Levenshtein : " + score);
        return score;
    }
}
