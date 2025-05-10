/*

import java.util.List;
import java.util.ArrayList;

public class mainPourComparateurDeNom {

	public static void main(String[] args) {
		Nom nom1=new Nom("NK-SZvshqfuEf7jn269Qyspv2", "Vazha Todua",null);
		Nom nom2=new Nom("NK-SZvshqfuEf7jn269Qyspv2", "Vazha Todua",null);
		
		List<CoupleDeString> list=new ArrayList<>();
		
		list.add(new CoupleDeString(nom1.getId(),nom1.getNom()));
		list.add(new CoupleDeString(nom2.getId(),nom2.getNom()));
		
		ListeDesNoms l=new ListeDesNoms(list);
		
		
		PretraiteurToLowerCase p = new PretraiteurToLowerCase();
		ListePretraiter l1=p.pretraiter(l);
		
		
		nom1=new Nom(l1.list().get(0).getElement1(),l1.list().get(0).getElement2(),null);
		nom2=new Nom(l1.list().get(1).getElement1(),l1.list().get(1).getElement2(),null);
		
		System.out.println(nom1.getId());
		System.out.println(nom2.getId());
		
		System.out.println(nom1.getNom());
		System.out.println(nom2.getNom());


		
		ComparateurJaro c=new ComparateurJaro();
		double score=c.comparer(nom1, nom2);
		System.out.println(score);

		

	}

}

*/
