import java.util.List;
import java.util.ArrayList;
public class Generateur1 implements GenerateurDeCandidat {

	public ListeGeneree generateur(ListeDesNoms listdenoms) {
		List<Nom> listCouple=new ArrayList<>();
		String nom;        
		int id;
		for(int i=0;i<listdenoms.liste().size();i++) {
			nom=listdenoms.liste().get(i).getNom();
			id=listdenoms.liste().get(i).getId();
			
			Nom couple = new Nom(id, nom);
			listCouple.add(couple);
				
				
			
		}
		
		return new ListeGeneree(listCouple);
	}
}
