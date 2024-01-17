package ReserVol;

public class Aeroport {
	private String code;
	private Ville ville;

	public Aeroport(String code, Ville ville) {
		this.code = code;
	    this.ville = ville;
	    }

    public String getCode() {
	    return code;
	    }
    public Ville getVille() {
	    return ville;
	    }
}
