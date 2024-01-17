package ReserVol;

public class ReservationFactory {

    public ReservationVol creerReservation(Vol vol, Passager passager) {
        // Logique pour créer une réservation
        return new ReservationVol(vol, passager);
    }
}
