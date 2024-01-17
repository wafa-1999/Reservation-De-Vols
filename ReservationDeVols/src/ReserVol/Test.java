package ReserVol;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        // Créer des instances et tester le système
        Ville newYork = new Ville("New York");
        Ville londres = new Ville("Londres");

        Aeroport jfk = new Aeroport("JFK", newYork);
        Aeroport lhr = new Aeroport("LHR", londres);

        CompagnieAerienne compagnie = new CompagnieAerienne("Tunisaire");

        Vol vol = new Vol(compagnie, jfk, lhr, new Date(), new Date(), 5);

        Passager passager1 = new Passager("Barkaalah wafa");
        Passager passager2 = new Passager("Challouf nour");
        Passager passager3 = new Passager("Jebli mariem");

        ReservationFactory reservationFactory = new ReservationFactory();

        ReservationVol reservation1 = reservationFactory.creerReservation(vol, passager1);
        ReservationVol reservation2 = reservationFactory.creerReservation(vol, passager2);
        ReservationVol reservation3 = reservationFactory.creerReservation(vol, passager3);

        Passager[] passagers = { passager1, passager2, passager3 };

        for (Passager passager : passagers) {
            if (vol.aDesPlacesDisponibles(1)) {
                ReservationVol reservation = reservationFactory.creerReservation(vol, passager);
                reservation.confirmer();
            } else {
                System.out.println("Pas assez de places disponibles pour la réservation de " + passager.getNom() + ".");
            }
        }
        
        
        //Ajout Escale
        Aeroport escaleAeroport = new Aeroport("CDG", new Ville("Paris"));
        Date escaleHeureDepart = new Date(); // Replace with the actual date and time
        Date escaleHeureArrivee = new Date(); 
        vol.ajouterEscale(escaleAeroport, escaleHeureDepart, escaleHeureArrivee);

        vol.afficherInfosPlaces();
        System.out.println("Nombre de places disponibles après les réservations : " + vol.getPlacesDisponibles());
    }
}
