

import java.util.List;
import java.util.ArrayList;

public class MoteurDeRecherche {
	protected ListeDesNoms listCSV;
	protected Selectionneur1 S;
	protected List<Pretraiteur> p;
	protected Comparateur C;
	protected Generateur1 G;
	protected Recuperateur1 R;
	private  double seuil;


	public MoteurDeRecherche(ListeDesNoms listCSV,double seuil, Selectionneur1 s, List<Pretraiteur> p, Comparateur c, Generateur1 g, Recuperateur1 r) {
		this.listCSV = listCSV;
		this.S = s;
		this.p = p;
		this.C = c;
		this.G = g;
		this.R = r;
		this.seuil=seuil;
	}

	public List<String> rechercher(ListeDesNoms listAchercher) {
		List<CoupleDeString> listNomtest = listCSV.liste(); 
		ListeDesNoms listNom=new ListeDesNoms(listNomtest);
		List<String> test =new ArrayList<>();
		List<String> candidats = new ArrayList<>();
		
		ListePretraiter listCSV = null;
		ListePretraiter listAcherchee = null;

		for(int i = 0; i < p.size(); i++) {
		    listCSV = p.get(i).pretraiter(listNom);
		    listAcherchee = p.get(i).pretraiter(listAchercher);
		}

		


		ListeGeneree couplesGeneres = G.generer(listAcherchee,listCSV);
		

		for (CoupleDeNom nomAcomparee : couplesGeneres.liste()) {
			Nom nom1=nomAcomparee.getNom1();
			Nom nom2=nomAcomparee.getNom2();
			if (C.comparer(nom1, nom2) >= seuil) {
				double score = C.comparer(nom1, nom2);
				String ligne = nom1.getNom() + ", " + nom2.getNom() + ", " + Double.toString(score);
				test.add(ligne);

			    candidats.addAll(test);
			}
		
			}
		

		return S.selectionner(candidats);
	}
}
