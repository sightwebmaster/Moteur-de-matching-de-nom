import java.util.List;
import java.util.ArrayList;

public class mainDePretraiteur {

    public static void main(String[] args) {
        Recuperateurfichecsv r = new Recuperateurfichecsv("peps_names_2k.csv");
        List<CoupleDeString> liste1 = r.recuperer();

        ListeDesNoms liste = new ListeDesNoms(liste1);

        List<Pretraiteur> p = new ArrayList<>();
        p.add(new PretraiteurToLowerCase());
        p.add(new PretraPretraiteurSansCaracteresNiChiffres());
        p.add(new PretraiteurAvecTokenisation());

        ListePretraiter listCSV = null;
        for (Pretraiteur pretraiteur : p) {
            listCSV = pretraiteur.pretraiter(liste); 
            liste = new ListeDesNoms(listCSV.list()); 
        }

        System.out.println("Résultat après tous les prétraitements :");
        for (CoupleDeString c : listCSV.list()) {
            System.out.println(c.getElement1() + " | " + c.getElement2());
        }
    }
}
