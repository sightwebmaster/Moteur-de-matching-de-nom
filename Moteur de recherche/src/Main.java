

import java.util.List;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
    	long startTime = System.currentTimeMillis();
        
        Recuperateur1 r = new Recuperateur1("peps_names_2k.csv");
        List<CoupleDeString> liste = r.recuperer();
        
        
        ComparateurDeChaine CompChaine=new ComparateurAvecJaroWinkler() ;
			
			
        
        ListeDesNoms listCSV =new ListeDesNoms(liste);
        
        // Liste des noms à chercher
        List<CoupleDeString> nomsAchercher = new ArrayList<>();
        nomsAchercher.add(new CoupleDeString("NK-SZvshqfuEf7jn269Qyspv2", "Obrahim Bawa Kamba"));

        // Création d'un objet ListeDesNoms
        ListeDesNoms listAchercher = new ListeDesNoms(nomsAchercher);

        // Initialisation des autres composants
        List<Pretraiteur> p = new ArrayList<>();
        p.add(new PretraiteurToLowerCase());
        p.add(new PretraiteurSansCaracteresNiChiffres());
        p.add(new PretraiteurAvecTokenisation());
        GenerateurDeCandidat g = new Generateur1();
        ComparateurJaro c = new ComparateurJaro(CompChaine);
        Selectionneur s = new SelectionneurParSeuil(0.5);
        

        // Initialisation du moteur de recherche
        MoteurDeRecherche moteur = new MoteurDeRecherche(listCSV, s, p, c, g, r);
       
        
        // Recherche
    //    List<NomAvecScore> resultats = moteur.rechercher(listAchercher);
        
        List<NomAvecScore> resultatsDeListeDedupliquee = moteur.dedupliquerListe(listCSV);
        
        
        /* 
  // Affichage des résultats
        for (NomAvecScore resultat  : resultats) {
            System.out.println("nom ="+resultat.getCouple().getNom1().getNom()+" nomcvs="+resultat.getCouple().getNom2().getNom()+"score="+resultat.getScore());
            
        }
        */
      
        for (NomAvecScore resultat  : resultatsDeListeDedupliquee) {
            System.out.println("nom ="+resultat.getCouple().getNom1().getNom()+" nomcvs="+resultat.getCouple().getNom2().getNom()+"score="+resultat.getScore());
             
        }
        
           
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total time: "+ totalTime +" ms");
        
        

    }
   
}


