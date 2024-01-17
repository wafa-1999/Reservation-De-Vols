package ReserVol;

import java.util.ArrayList;
import java.util.List;

public class CompagnieAerienne {
    private String nom;
    private List<Vol> vols;

    public CompagnieAerienne(String nom) {
        this.nom = nom;
        this.vols = new ArrayList<>();
    }

    public void ajouterVol(Vol vol) {
        vols.add(vol);
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}