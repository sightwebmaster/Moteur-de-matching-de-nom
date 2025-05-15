import java.util.List;
import java.util.ArrayList;

public class mainPourComparateurDeNom {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		Recuperateurfichecsv r = new Recuperateurfichecsv("peps_names_2k.csv");
		List<CoupleDeString> liste = r.recuperer();
		ListeDesNoms listNom = new ListeDesNoms(liste);

		Nom nomRecherche = new Nom("REF-ID", "Vazha Todua", null);

		PretraiteurToLowerCase pretraiteur = new PretraiteurToLowerCase();
		ListeDesNoms temp = new ListeDesNoms(List.of(
				new CoupleDeString(nomRecherche.getId(), nomRecherche.getNom())
		));
		ListePretraiter pretraite = pretraiteur.pretraiter(temp);
		nomRecherche = new Nom(pretraite.list().get(0).getElement1(), pretraite.list().get(0).getElement2(), null);


		ListePretraiter listePretraitee = pretraiteur.pretraiter(listNom);
		List<CoupleDeString> nomsPretraite = listePretraitee.list();


		ComparateurDeChaine comparateurChaine = new ComparateurAvecJaroWinkler();
		Comparateur comparateurNom = new ComparateurJaro(comparateurChaine);

		int i = 0;
		for (CoupleDeString c : nomsPretraite) {
			Nom nomActuel = new Nom(c.getElement1(), c.getElement2(), null);
			double score = comparateurNom.comparer(nomRecherche, nomActuel);
			System.out.printf("(%d) %s <-> %s => Score: %.4f\n", ++i, nomRecherche.getNom(), nomActuel.getNom(), score);
		}

		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("⏱️ Temps total: " + totalTime + " ms");

		AnalyseMemoire.afficherMemoire("📦 Après comparaison");
	}
}
