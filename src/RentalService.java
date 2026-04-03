import java.util.List;

public class RentalService {
    public static final double BASE_FARE = 3.0;
    private List<ActiveRental> activeRentals;

    public RentalService(List<ActiveRental> activeRentals) {
        this.activeRentals = activeRentals;
    }

    public void startRental(ActiveRental rental) {
        activeRentals.add(rental);
    }

    public void endRental(ActiveRental rental) {
        activeRentals.remove(rental);
    }

    public ActiveRental findActiveRental(int userId) {
        for (ActiveRental r : activeRentals) {
            if (r.getUserId() == userId) {
                return r;
            }
        }
        return null;
    }

    public void simulateApplicationInput(RegisteredUsers user) {
        System.out.println("Rental service initiated for: " + user.getFullName());
        user.displayUserType();
    }

    public void removeTrip(RegisteredUsers user) {
        double fare = user.calculateFare(BASE_FARE);
        System.out.println("Trip ended for: " + user.getFullName());
        System.out.println("Calculated fare: " + fare);
    }
}
