

import java.util.List;
import java.util.ArrayList;

public class MoteurDeRecherche {
	protected ListeDesNoms listCSV;
	protected Selectionneur S;
	protected List<Pretraiteur> p;
	protected Comparateur C;
	protected GenerateurDeCandidat G;
	protected Recuperateur1 R;



	public MoteurDeRecherche(ListeDesNoms listCSV, Selectionneur s, List<Pretraiteur> p, Comparateur c, GenerateurDeCandidat g, Recuperateur1 r) {
		this.listCSV = listCSV;
		this.S = s;
		this.p = p;
		this.C = c;
		this.G = g;
		this.R = r;
	
	}

	public List<NomAvecScore> rechercher(ListeDesNoms listAchercher) {
		List<CoupleDeString> listNomtest = listCSV.liste(); 
		ListeDesNoms listNom=new ListeDesNoms(listNomtest);
		List<NomAvecScore> candidats = new ArrayList<>();
		
		
		ListePretraiter listCSV = null;
		ListePretraiter listAcherchee = null;

		for(int i = 0; i < p.size(); i++) {
		    listCSV = p.get(i).pretraiter(listNom);
		    listNom =new ListeDesNoms(listCSV.list());
		    listAcherchee = p.get(i).pretraiter(listAchercher);
		    listAchercher=new ListeDesNoms(listAchercher.liste());
		}

		


		ListeGeneree couplesGeneres = G.generer(listAcherchee,listCSV);
		
		

		for (CoupleDeNom nomAcomparee : couplesGeneres.liste()) {
			Nom nom1=nomAcomparee.getNom1();
			Nom nom2=nomAcomparee.getNom2();
			double score=C.comparer(nom1, nom2);
			candidats.add(new NomAvecScore(nomAcomparee,score));
			
		
			}
	
		

		return S.selectionner(candidats);
	}
	
	public List<NomAvecScore> dedupliquerListe(ListeDesNoms listCSV) {
	    List<NomAvecScore> resultats = new ArrayList<>();

	    for (CoupleDeString couple : listCSV.liste()) {
	        ListeDesNoms sousListe = new ListeDesNoms(List.of(couple));
	        resultats.addAll(rechercher(sousListe));
	    }

	    return resultats;
	}

}
