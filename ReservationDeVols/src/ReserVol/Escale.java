package ReserVol;

import java.util.Date;

public class Escale {
	
	private Aeroport aeroport;
    private Date heureDepart;
    private Date heureArrivee;

    public Escale(Aeroport aeroport, Date heureDepart, Date heureArrivee) {
        this.aeroport = aeroport;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
    }
    public Aeroport getAeroport() {
        return aeroport;
    }
	public Date getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}
	public Date getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

}
