import java.util.List;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		

	
	
	
	 Generateur1 g = new Generateur1();
     Pretraiteur1 p = new Pretraiteur1(); 
     Comparateur1 c = new Comparateur1(); 
     Selectionneur1 s = new Selectionneur1(); 
     Recuperateur r =new Recuperateur1();
     
     Nom nomchercher=new Nom(1,"Haythem");

     
     MoteurDeRecherche moteur = new MoteurDeRecherche(nomchercher,0.5, s, p, c, g, r);
     
     List<Nom> resultats = moteur.rechercher(nomchercher);

     
     System.out.println("Résultats trouvés :");
     for (Nom n : resultats) {
         System.out.println("- " + n.getNom() + " (id: " + n.getId() + ")");
     }
}

}
