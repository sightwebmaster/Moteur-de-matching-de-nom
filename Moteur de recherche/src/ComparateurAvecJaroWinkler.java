import org.apache.commons.text.similarity.JaroWinklerSimilarity;

public class ComparateurAvecJaroWinkler implements ComparateurDeChaine {

    @Override
    public double comparer(String nom1, String nom2) {
        JaroWinklerSimilarity jw = new JaroWinklerSimilarity();
        double score = jw.apply(nom1, nom2);
      //  System.out.println("Score JaroWinkler : " + score);
        return score;
    }
}
