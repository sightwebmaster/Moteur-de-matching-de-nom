/*

import java.util.List;
import java.util.ArrayList;

public class mainDePretraiteur {

    public static void main(String[] args) {
        // Création d'une liste de CoupleDeString
        List<CoupleDeString> noms = new ArrayList<>();
        noms.add(new CoupleDeString("NK-SZvshqfuEf7jn269Qyspv2", "Vazha Todua"));

        // Création d'un objet ListeDesNoms
        ListeDesNoms liste = new ListeDesNoms(noms);

        // Application du prétraiteur
        PretraiteurToLowerCase p = new PretraiteurToLowerCase();
        ListePretraiter resultat = p.pretraiter(liste);

        // Affichage des résultats
        for (CoupleDeString c : resultat.list()) {
            System.out.println(c.getElement1() + " | " + c.getElement2());
        }
    }
}


*/