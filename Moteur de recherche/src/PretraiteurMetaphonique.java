


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.language.Metaphone;
public class PretraiteurMetaphonique implements Pretraiteur{
	
	
	 public ListePretraiter pretraiter(ListeDesNoms list) {
		 List<CoupleDeString> listeOriginale = list.liste();
		 List<CoupleDeString> listeModifiee = new ArrayList<>();
		     
		 Metaphone soundex = new Metaphone();
		 for( CoupleDeString couple : listeOriginale) {
	            String element1 = couple.getElement1();
	            String element2 = soundex.encode(couple.getElement2());
	            listeModifiee.add(new CoupleDeString(element1, element2));
	        }
	        

	        return new ListePretraiter(listeModifiee);
	 }
	 }
	
	
	
	
	
	



