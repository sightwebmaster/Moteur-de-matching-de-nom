import java.util.List;
import java.util.ArrayList;
public class MoteurDeRecherche {
	protected String nom;
	protected ListeDesNoms L1;
	protected ListePretraiter L2;
	protected ListeGeneree L3;
	protected Selectionneur S;
	protected Pretraiteur p;
	protected Comparateur C;
	protected GenerateurDeCandidat G;
	protected Recuperateur R;
	private int nb;
	
	
	public MoteurDeRecherche(String nom, ListeDesNoms l1, ListePretraiter l2, ListeGeneree l3,
			 Selectionneur s, Pretraiteur p, Comparateur c, GenerateurDeCandidat g, Recuperateur r,
			int nb) {
		super();
		this.nom = nom;
		L1 = l1;
		L2 = l2;
		L3 = l3;
		S = s;
		this.p = p;
		C = c;
		G = g;
		R = r;
		this.nb = nb;
	}


		List<String> rechercher(String nom,ListePretraiter noms ,Comparateur c ,Selectionneur s) {
			List<String> listNom = noms.list();
			List<String> listSelection = new ArrayList<String>();
		
			for(int i=0;i<nb;i++) {
				if(listNom.get(i).equals(nom)) {
					listSelection.add(nom);
				}
			}
			return listSelection;
		
		
		
	}
}
