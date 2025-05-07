import java.util.List;
import java.util.ArrayList;

public class MoteurDeRecherche {
	protected Nom nom;
	protected Selectionneur1 S;
	protected Pretraiteur1 p;
	protected Comparateur1 C;
	protected Generateur1 G;
	protected Recuperateur R;
	private final double seuil;

	public MoteurDeRecherche(Nom nomchercher,double seuil, Selectionneur1 s, Pretraiteur1 p, Comparateur1 c, Generateur1 g, Recuperateur r) {
		this.nom = nomchercher;
		this.S = s;
		this.p = p;
		this.C = c;
		this.G = g;
		this.R = r;
		this.seuil=seuil;
	}

	public List<Nom> rechercher(Nom nomChercher) {
		ListeDesNoms listNom = R.recuperer(); 
		List<Nom> candidats = new ArrayList<>();

		ListeGeneree couplesGeneres = G.generateur(listNom);
		ListePretraiter couplesPretraitees = p.pretraiteur(couplesGeneres);

		for (Nom nomAcomparee : couplesPretraitees.list()) {

			if (C.comparer(nomAcomparee, nomChercher) >= seuil) {
				candidats.add(nomAcomparee);
			}
		
			}
		

		return S.selectionner(candidats);
	}
}
