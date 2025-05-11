

import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        Recuperateur1 r = new Recuperateur1("peps_names_800.csv");
        List<CoupleDeString> liste = r.recuperer();
        
        
        ComparateurDeChaine CompChaine=new ComparateurAvecJaroWinkler() ;
			
			
        
        ListeDesNoms listCSV =new ListeDesNoms(liste);
        
        // Liste des noms à chercher
        List<CoupleDeString> nomsAchercher = new ArrayList<>();
        nomsAchercher.add(new CoupleDeString("NK-SZvshqfuEf7jn269Qyspv2", "victor manuel ortiz joya"));

        // Création d'un objet ListeDesNoms
        ListeDesNoms listAchercher = new ListeDesNoms(nomsAchercher);

        // Initialisation des autres composants
        List<Pretraiteur> p = new ArrayList<>();
        p.add(new PretraiteurToLowerCase());
        Generateur1 g = new Generateur1();
        ComparateurJaro c = new ComparateurJaro(CompChaine);
        Selectionneur s = new SelectionneurDesNmeilleurs(10);
        

        // Initialisation du moteur de recherche
        MoteurDeRecherche moteur = new MoteurDeRecherche(listCSV, s, p, c, g, r);
       
        
        // Recherche
        List<NomAvecScore> resultats = moteur.rechercher(listAchercher);

        // Affichage des résultats
        for (NomAvecScore resultat  : resultats) {
            System.out.println("nom ="+resultat.getCouple().getNom1().getNom()+" nomcvs="+resultat.getCouple().getNom2().getNom()+"score="+resultat.getScore());
            
        }
        System.out.println(listCSV.liste().get(0));
    }
}


