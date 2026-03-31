import java.util.List;

public class RentalService {
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
}
