package ReserVol;

import java.util.Date;

public class ReservationVol {

    private Vol vol;
    private Passager passager;
    private boolean estConfirmee;

    public ReservationVol(Vol vol, Passager passager) {
        this.vol = vol;
        this.passager = passager;
        this.estConfirmee = false;
    }

    public void confirmer() {
        if (vol.aDesPlacesDisponibles(1)) {
            estConfirmee = true;
            vol.reduirePlacesDisponibles(1);
            System.out.println("Réservation confirmée pour " + passager.getNom());
        } else {
            // Gérer le cas où il n'y a pas assez de places
            System.out.println("Pas assez de places disponibles pour confirmer la réservation.");
        }
    }

    public void annuler() {
        estConfirmee = false;
        vol.augmenterPlacesDisponibles(1);
        System.out.println("Réservation annulée pour " + passager.getNom());
    }
}
