import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Bike {
    private String bikeID;
    private boolean isAvailable;
    private int batteryLevel;
    private LocalDateTime lastUsedTime;
    private String location;

    public Bike() {}

    public Bike(String bikeID, boolean isAvailable, int batteryLevel, LocalDateTime lastUsedTime, String location) {
        this.bikeID = bikeID;
        this.isAvailable = isAvailable;
        this.batteryLevel = batteryLevel;
        this.lastUsedTime = lastUsedTime;
        this.location = location;
    }

    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public LocalDateTime getLastUsedTime() {
        return lastUsedTime;
    }

    public void setLastUsedTime(LocalDateTime lastUsedTime) {
        this.lastUsedTime = lastUsedTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeID='" + bikeID + '\'' +
                ", isAvailable=" + isAvailable +
                ", batteryLevel=" + batteryLevel +
                ", lastUsedTime=" + lastUsedTime +
                ", location='" + location + '\'' +
                '}';
    }
}

class ActiveRental {
    private String bikeID;
    private String userEmail;
    private LocalDateTime tripStartTime;

    public ActiveRental() {}

    public ActiveRental(String bikeID, String userEmail, LocalDateTime tripStartTime) {
        this.bikeID = bikeID;
        this.userEmail = userEmail;
        this.tripStartTime = tripStartTime;
    }

    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDateTime getTripStartTime() {
        return tripStartTime;
    }

    public void setTripStartTime(LocalDateTime tripStartTime) {
        this.tripStartTime = tripStartTime;
    }

    @Override
    public String toString() {
        return "ActiveRental{" +
                "bikeID='" + bikeID + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", tripStartTime=" + tripStartTime +
                '}';
    }
}

class BikeDatabase {
    public static ArrayList<Bike> bikes;

    static {
        bikes = new ArrayList<>();
        bikes.add(new Bike("B001", true, 95, LocalDateTime.of(2026, 3, 25, 9, 30), "Central Park"));
        bikes.add(new Bike("B002", false, 60, LocalDateTime.of(2026, 3, 26, 15, 20), "Train Station"));
        bikes.add(new Bike("B003", true, 85, LocalDateTime.of(2026, 3, 27, 8, 45), "Central Park"));
        bikes.add(new Bike("B004", true, 70, LocalDateTime.of(2026, 3, 27, 10, 10), "City Mall"));
        bikes.add(new Bike("B005", false, 40, LocalDateTime.of(2026, 3, 27, 12, 0), "City Mall"));
    }
}

class UserRegistration {
    public void registration() {
        System.out.println("=== User Registration Process ===");
        System.out.println("Registration successful! You are now a registered ERyder user.");
    }
}

class BikeRental {
    private boolean isRegisteredUser;
    private String emailAddress;
    private String location;
    private LocalDateTime tripStartTime;
    private String bikeID;
    private boolean locationValid;

    private UserRegistration userRegistration = new UserRegistration();
    private ActiveRental activeRental;
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public void simulateApplication() {
        System.out.println("\nThis is the simulation of the e-bike rental process.");

        System.out.print("Are you a registered user (true/false): ");
        isRegisteredUser = scanner.nextBoolean();
        scanner.nextLine();
        System.out.print("Enter your email address: ");
        emailAddress = scanner.nextLine();
        System.out.print("Enter the rental location: ");
        location = scanner.nextLine();

        System.out.println("Simulating the analysis of the rental request.");
        bikeID = analyseRequest(isRegisteredUser, emailAddress, location);

        if (!locationValid) {
            return;
        }

        System.out.println("Simulating e-bike reservation…");
        reserveBike(bikeID);

        System.out.println("Displaying the active rentals…");
        viewActiveRentals();

        System.out.println("Simulating the end of the trip…");
        removeTrip(bikeID);

        System.out.println("Displaying the active rentals after trip end…");
        viewActiveRentals();
    }

    private String analyseRequest(boolean isRegistered, String email, String loc) {
        if (isRegistered) {
            System.out.println("Welcome back, " + email + "!");
        } else {
            System.out.println("You’re not our registered user. Please consider registering.");
            userRegistration.registration();
        }
        return validate(loc);
    }

    private String validate(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equals(location) && bike.isAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes are available at the location you requested. Please try again later.");
        locationValid = false;
        return null;
    }

    private void reserveBike(String bikeID) {
        if (bikeID != null) {
            for (Bike bike : BikeDatabase.bikes) {
                if (bike.getBikeID().equals(bikeID)) {
                    tripStartTime = LocalDateTime.now();
                    bike.setIsAvailable(false);
                    bike.setLastUsedTime(tripStartTime);
                    System.out.println("Reserving the bike with the " + bikeID + ". Please follow the on-screen instructions to locate the bike and start your pleasant journey.");
                    activeRental = new ActiveRental(bikeID, emailAddress, tripStartTime);
                    activeRentalsList.add(activeRental);
                    break;
                }
            }
        } else {
            System.out.println("Sorry, we’re unable to reserve a bike at this time. Please try again later.");
        }
    }

    private void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals at the moment.");
        } else {
            for (ActiveRental rental : activeRentalsList) {
                System.out.println(rental);
            }
        }
    }

    private void removeTrip(String bikeID) {
        Iterator<ActiveRental> iterator = activeRentalsList.iterator();
        while (iterator.hasNext()) {
            ActiveRental rental = iterator.next();
            if (rental.getBikeID().equals(bikeID)) {
                iterator.remove();
                break;
            }
        }

        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setIsAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                System.out.println("Your trip has ended. Thank you for riding with us.");
                break;
            }
        }
    }
}

class AdminPanel {
    private Scanner scanner = new Scanner(System.in);

    public void showAdminMenu() {
        while (true) {
            System.out.println("\n=== ERyder Admin Panel ===");
            System.out.println("1. Other Features (Reserved)");
            System.out.println("2. Demo the Bike Rental System");
            System.out.println("3. Exit System");
            System.out.print("Enter your choice (1/2/3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Other features are under development.");
                    break;
                case 2:
                    BikeRental bikeRental = new BikeRental();
                    bikeRental.simulateApplication();
                    break;
                case 3:
                    System.out.println("Exiting ERyder Admin Panel. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter 1, 2 or 3.");
            }
        }
    }
}
