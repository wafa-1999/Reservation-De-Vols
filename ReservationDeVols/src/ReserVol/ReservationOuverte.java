package ReserVol;

import java.util.Date;

public class ReservationOuverte {

    private boolean estOuverte; // Indicates whether the reservation is open
    private Date dateOuverture;
    private Date dateFermeture;

    // GRASP Principle 1: Information Expert
    // Method to open a reservation
    public void ouvrir() {
        if (!estOuverte) {
            estOuverte = true;
            dateOuverture = new Date();
            // Additional logic for opening a reservation
            System.out.println("Réservation ouverte le " + dateOuverture);
        } else {
            System.out.println("La réservation est déjà ouverte.");
        }
    }

    // Method to close a reservation
    public void fermer() {
        if (estOuverte) {
            estOuverte = false;
            dateFermeture = new Date();
            // Additional logic for closing a reservation
            System.out.println("Réservation fermée le " + dateFermeture);
        } else {
            System.out.println("La réservation est déjà fermée.");
        }
    }
}
