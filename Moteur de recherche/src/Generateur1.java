import java.util.List;
import java.util.ArrayList;
public class Generateur1 implements GenerateurDeCandidat {

	public ListeGeneree generer(ListePretraiter list1,ListePretraiter list2) {
		List<CoupleDeNom> listCouple=new ArrayList<>();
		

		
		for(int i=0;i<list1.list().size();i++) {
			for(int j=0;j<list2.list().size();j++) {
				String id1=list1.list().get(i).getElement1();
				String nom1=list1.list().get(i).getElement2();
				String id2=list2.list().get(j).getElement1();
				String nom2=list2.list().get(j).getElement2();
				
				
				Nom nomDeList1=new Nom(id1,nom1,null);
				Nom nomDeList2=new Nom(id2,nom2,null);
				listCouple.add(new CoupleDeNom(nomDeList1, nomDeList2));
			}
		}
		
		
		
		return new ListeGeneree(listCouple);
	}
}
