import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Generateur1 implements GenerateurDeCandidat {






	public Map<String, List<CoupleDeString>> indexer(ListePretraiter listeNoms) {
		Map<String, List<CoupleDeString>> index = new HashMap<>();

		for (CoupleDeString couple : listeNoms.list()) {
			String chaine = couple.getElement2().trim();
			if (chaine.isEmpty()) continue;

			String[] mots = chaine.split("\\s+"); // Séparation par espace
			for (String mot : mots) {
				index.computeIfAbsent(mot.toLowerCase(), k -> new ArrayList<>()).add(couple);
			}
		}

		return index;
	}

	public ListeGeneree generer(ListePretraiter aChercher, ListePretraiter csv) {
		Map<String, List<CoupleDeString>> index = indexer(csv);
		List<CoupleDeString> candidats = new ArrayList<>();
		List<CoupleDeNom> couples = new ArrayList<>();


		for(CoupleDeString couple : aChercher.list()) {
			String key = couple.getElement2();
			for (String mot : key.split("\\s+")) {
				List<CoupleDeString> correspondants = index.get(mot.toLowerCase());
				if (correspondants != null) {
					for (CoupleDeString c : correspondants) {
						Nom nom1 = new Nom(couple.getElement1(), couple.getElement2(), null);
						Nom nom2 = new Nom(c.getElement1(), c.getElement2(), null);
						couples.add(new CoupleDeNom(nom1, nom2));
					}
				}
			}


		}


		for(String c : index.keySet()) {
			for(int i=0;i<index.get(c).size();i++) {
				for(int j=i+1;j<i;j++) {
					Nom nom1=new Nom(index.get(c).get(i).getElement1(),index.get(c).get(i).getElement2(),null);
					Nom nom2=new Nom(index.get(c).get(j).getElement1(),index.get(c).get(j).getElement2(),null);
					couples.add(new CoupleDeNom(nom1, nom2));

				}
			}

		}





		return new ListeGeneree(couples);
	}
}