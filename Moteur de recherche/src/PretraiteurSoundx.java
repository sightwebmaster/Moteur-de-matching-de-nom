

import org.apache.commons.text.similarity.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.language.Soundex;
public class PretraiteurSoundx implements Pretraiteur{
	
	
	 public ListePretraiter pretraiter(ListeDesNoms list) {
		 List<CoupleDeString> listeOriginale = list.liste();
		 List<CoupleDeString> listeModifiee = new ArrayList<>();
		     
		 Soundex soundex = new Soundex();
		 for( CoupleDeString couple : listeOriginale) {
	            String element1 = couple.getElement1();
	            String element2 = soundex.encode(couple.getElement2());
	            listeModifiee.add(new CoupleDeString(element1, element2));
	        }
	        

	        return new ListePretraiter(listeModifiee);
	 }
	 }
	
	
	
	
	
	



