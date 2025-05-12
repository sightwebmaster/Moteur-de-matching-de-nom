/*
import java.util.List;
import java.util.ArrayList;

public class mainDePretraiteur {

    public static void main(String[] args) {
        // Création d'une liste de CoupleDeString
        List<CoupleDeString> noms = new ArrayList<>();
        noms.add(new CoupleDeString("NK-SZvshqfuEf7jn269Qyspv2", "Vazha To!$ùdua"));
        noms.add(new CoupleDeString("NK-SZvshqfuEf7jn269Qyspv2", "Ahmed Ben47 Chaaben"));
        noms.add(new CoupleDeString("NK-SZvshqfuEf7jn269Qyspv2", "Hmed 2 Ben Chaa47ben hello world"));



        // Création d'un objet ListeDesNoms
        ListeDesNoms liste = new ListeDesNoms(noms);

        // Application du prétraiteur
        Pretraiteur p = new PretraiteurAvecTokenisation();
        Pretraiteur p1 = new PretraiteurSansCaracteresNiChiffres();
        Pretraiteur p2 = new PretraiteurMetaphonique();

        

        ListePretraiter resultat = p1.pretraiter(liste);
        

        // Affichage des résultats
        for (CoupleDeString c : resultat.list()) {
            System.out.println(c.getElement2() );
        }
    }
}

*/
