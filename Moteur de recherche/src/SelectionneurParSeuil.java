import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SelectionneurParSeuil implements Selectionneur {
    private double seuil;

    public SelectionneurParSeuil(double seuil) {
        this.seuil = seuil;
    }

    @Override
    public List<NomAvecScore> selectionner(List<NomAvecScore> list) {
        // Trier la liste par score décroissant
        Collections.sort(list, new ComparateurDeScore());
        Collections.reverse(list);
        

        // Sélectionner les éléments au-dessus du seuil
        for (int i=0;i<list.size();i++) {
            if (list.get(i).getScore() >= seuil) {
                return list.subList(0, i);
            }
        }
		return null;

        
    }

    public double getSeuil() {
        return seuil;
    }

    public void setSeuil(double seuil) {
        this.seuil = seuil;
    }
}
