import java.util.ArrayList;
import java.util.List;

public class mainPourGenerateur {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Recuperateurfichecsv r = new Recuperateurfichecsv("peps_names_16k.csv");
        List<CoupleDeString> liste = r.recuperer();

        ListeDesNoms listNom = new ListeDesNoms(liste);

        ComparateurDeChaine CompChaine = new ComparateurAvecJaroWinkler();

        List<Pretraiteur> p = new ArrayList<>();
        p.add(new PretraiteurToLowerCase());
        p.add(new PretraPretraiteurSansCaracteresNiChiffres());
        p.add(new PretraiteurAvecTokenisation());

        ListePretraiter listCSV = null;
        for (Pretraiteur pretraiteur : p) {
            listCSV = pretraiteur.pretraiter(listNom);
            listNom = new ListeDesNoms(listCSV.list());
        }

        GenerateurDeCandidat g = new GenerateurParTaille();

        List<CoupleDeString> nomsAchercher = new ArrayList<>();
        nomsAchercher.add(new CoupleDeString("NK-SZvshqfuEf7jn269Qyspv2", "Mustapha Abubakar"));
        ListePretraiter list1=new ListePretraiter(nomsAchercher);
        ListeGeneree list = g.generer(list1,listCSV);

        for (CoupleDeNom couple : list.liste()) {
            System.out.println("nom1="+couple.getNom1().getNom()+"nom2="+couple.getNom2().getNom());
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time: "+ totalTime +" ms");
        AnalyseMemoire.afficherMemoire("après la recherche");


    }
}