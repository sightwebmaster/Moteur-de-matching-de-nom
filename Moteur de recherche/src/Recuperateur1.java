import java.util.List;
import java.util.ArrayList;

public class Recuperateur1 implements Recuperateur {

    
    public ListeDesNoms recuperer() {
        Nom nom1 = new Nom(11, "Ahmed");
        Nom nom2 = new Nom(2, "Barhoum");
        Nom nom3 = new Nom(3, "Haythem");
        Nom nom4 = new Nom(4, "Ahmed");


        List<Nom> noms = new ArrayList<>();
        noms.add(nom1);
        noms.add(nom2);
        noms.add(nom3);
        noms.add(nom4);

        return new ListeDesNoms(noms);
    }
    
}

	
	

