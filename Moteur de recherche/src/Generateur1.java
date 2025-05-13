
import java.util.List;
import java.util.ArrayList;


public class Generateur1 implements GenerateurDeCandidat {

    public ListeGeneree generer(ListePretraiter list1, ListePretraiter list2) {
        List<CoupleDeString> elements1 = list1.list();
        List<CoupleDeString> elements2 = list2.list();
        List<CoupleDeNom> listCouple = new ArrayList<>();

        for (CoupleDeString e1 : elements1) {
            for (CoupleDeString e2 : elements2) {
                Nom nom1 = new Nom(e1.getElement1(), e1.getElement2(), null);
                Nom nom2 = new Nom(e2.getElement1(), e2.getElement2(), null);
                listCouple.add(new CoupleDeNom(nom1, nom2));
            }
        }

        return new ListeGeneree(listCouple);
    }
}