import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GenerateurDeCandidatAvecUtilisantIndex implements GenerateurDeCandidat {

    
    
    public Map<Integer, List<CoupleDeString>> indexer(ListePretraiter listeNoms) {
        Map<Integer, List<CoupleDeString>> index = new HashMap<>();

        for (CoupleDeString couple : listeNoms.list()) {
            String chaine2 = couple.getElement2().trim();
            if (chaine2.isEmpty()) continue;

            int key = chaine2.length(); // Clé = longueur en caractères
            index.computeIfAbsent(key, k -> new ArrayList<>()).add(couple);
        }

        return index;
    }

    
    public int extraireCle(String chaine) {
        return chaine.trim().length(); // Retourne directement la longueur
    }

    
    public ListeGeneree generer(ListePretraiter aChercher, ListePretraiter csv) {
        Map<Integer, List<CoupleDeString>> index = indexer(csv);
        List<CoupleDeNom> couples = new ArrayList<>();
        List<CoupleDeString> candidats = new ArrayList<>();

        for (CoupleDeString cible : aChercher.list()) {
            String nomAChercher = cible.getElement2();
            int taille = nomAChercher.length();

            for (int cle : index.keySet()) {
            	if(taille <= 1.5*cle) {
            		candidats.addAll(index.get(cle));
            	}

                if (candidats != null) {
                    for (CoupleDeString candidat : candidats) {
                        Nom nom1 = new Nom(cible.getElement1(), cible.getElement2(), null);
                        Nom nom2 = new Nom(candidat.getElement1(), candidat.getElement2(), null);
                        couples.add(new CoupleDeNom(nom1, nom2));
                    }
                }
            }
        }

        return new ListeGeneree(couples);
    }
}
