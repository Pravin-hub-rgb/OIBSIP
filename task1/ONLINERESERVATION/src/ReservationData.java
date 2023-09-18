import java.util.ArrayList;
import java.util.List;

public class ReservationData {
    private static List<Reservation> reservations = new ArrayList<>();
    private static int nextPNRNumber = 11010; // Initialize the next PNR number
    // Initialize some prebuilt reservation records
    static {
        reservations.add(new Reservation("123", "First Class", "2023-09-10", "Punjab", "Gujarat", nextPNRNumber++));
        reservations.add(new Reservation("456", "Second Class", "2023-09-15", "Jammu", "Kanyakumari", nextPNRNumber++));
        // Add more sample reservations as needed
    }

    // Get the list of reservations
    public static List<Reservation> getReservations() {
        return reservations;
    }

    public static int getNextAvailablePNR() {
        return nextPNRNumber++;
    }

    public static Reservation getReservationByPNR(int pnrNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getPNR() == pnrNumber) {
                return reservation;
            }
        }
        return null; // Return null if no matching reservation is found
    }

    // Add a new reservation to the list
    public static void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    // Remove a reservation from the list
    public static void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }
}
