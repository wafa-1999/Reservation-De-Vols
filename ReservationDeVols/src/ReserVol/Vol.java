package ReserVol;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vol {

    private CompagnieAerienne compagnie;
    private Aeroport aeroportDepart;
    private Aeroport aeroportArrivee;
    private Date heureDepart;
    private Date heureArrivee;
    private List<Escale> escales;
    private int placesDisponibles;
    private int placesReservees;
    
    
    public Vol(CompagnieAerienne compagnie, Aeroport aeroportDepart, Aeroport aeroportArrivee,
               Date heureDepart, Date heureArrivee, int placesDisponibles) {
        this.compagnie = compagnie;
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrivee = aeroportArrivee;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.placesDisponibles = placesDisponibles;
        this.placesReservees = 0;
        this.escales = new ArrayList<>();
    }

    public boolean aDesPlacesDisponibles(int nombreDePlaces) {
        return placesDisponibles >= nombreDePlaces;
    }

    public void reduirePlacesDisponibles(int nombreDePlaces) {
        // Logic to reduce available seats
        if (nombreDePlaces <= placesDisponibles) {
            placesDisponibles -= nombreDePlaces;
            placesReservees += nombreDePlaces; // Increment reserved seats
        } else {
            // Handle the case where there are not enough available seats
            System.out.println("Pas assez de places disponibles pour réduire.");
        }
    }
    
    
    // New method to increase available seats
    public void augmenterPlacesDisponibles(int nombreDePlaces) {
        // Logic to increase available seats
        placesDisponibles += nombreDePlaces;
        placesReservees -= nombreDePlaces; // Decrement reserved seats
    }
    
    public void afficherInfosPlaces() {
        System.out.println("Informations sur le vol :");
        System.out.println("Compagnie aérienne : " + compagnie.getNom());
        System.out.println("Aéroport de départ : " + aeroportDepart.getCode() + " - " + aeroportDepart.getVille().getNom());
        System.out.println("Aéroport d'arrivée : " + aeroportArrivee.getCode() + " - " + aeroportArrivee.getVille().getNom());
        System.out.println("Date de départ : " + formatDate(heureDepart));
        System.out.println("Date d'arrivée : " + formatDate(heureArrivee));
        System.out.println("Nombre total de places : " + (placesDisponibles + placesReservees));
        System.out.println("Nombre de places réservées : " + placesReservees);
        System.out.println("Nombre de places disponibles : " + getPlacesDisponibles());

        List<Escale> escales = getEscales();
        if (!escales.isEmpty()) {
            System.out.println("Escales :");
            for (Escale escale : escales) {
                System.out.println("Aéroport : " + escale.getAeroport().getCode() + " - " + escale.getAeroport().getVille().getNom());
                System.out.println("Heure de départ : " + formatDate(escale.getHeureDepart()));
                System.out.println("Heure d'arrivée : " + formatDate(escale.getHeureArrivee()));
            }
        } else {
            System.out.println("Pas d'escales pour ce vol.");
        }
    }

    public int getPlacesDisponibles() {
		
		return placesDisponibles;
	}

	private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return dateFormat.format(date);
    }


	public void ajouterEscale(Aeroport aeroport, Date heureDepart, Date heureArrivee) {
        Escale escale = new Escale(aeroport, heureDepart, heureArrivee);
        escales.add(escale);
    }

    public List<Escale> getEscales() {
        return escales;
    }
}
