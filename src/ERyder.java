public class ERyder {
    public static final String COMPANY_NAME = "ERyder";
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;

    private final String LINKED_ACCOUNT;
    private final String LINKED_PHONE_NUMBER;

    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    private int totalUsageInMinutes;
    private double totalFare;

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven,
                  String linkedAccount, String linkedPhoneNumber) {
        this.bikeID = bikeID;
        setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = linkedAccount;
        this.LINKED_PHONE_NUMBER = linkedPhoneNumber;
    }

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.LINKED_ACCOUNT = "default_user";
        this.LINKED_PHONE_NUMBER = "000-0000-0000";
    }

    public void ride() {
        if (isAvailable && batteryLevel > 0) {
            System.out.println("The bike is available.");
        } else {
            System.out.println("The bike is not available.");
        }
    }

    public void printBikeDetails() {
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("Distance Travelled: " + kmDriven + " km");
        System.out.println("------------------------------");
    }

    public void printRideDetails(int usageInMinutes) {
        this.totalUsageInMinutes = usageInMinutes;
        this.totalFare = calculateFare(usageInMinutes);
        System.out.println("=== Ride Details ===");
        System.out.println("Company Name: " + COMPANY_NAME);
        System.out.println("Linked Account: " + LINKED_ACCOUNT);
        System.out.println("Linked Phone Number: " + LINKED_PHONE_NUMBER);
        System.out.println("Bike ID: " + bikeID);
        System.out.println("Usage in Minutes: " + totalUsageInMinutes + " mins");
        System.out.println("Total Fare: $" + String.format("%.2f", totalFare));
        System.out.println("------------------------------");
    }

    private double calculateFare(int usageInMinutes) {
        return BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
    }

    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Error: Battery level must be between 0 and 100.");
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(double kmDriven) {
        this.kmDriven = kmDriven;
    }

    public int getTotalUsageInMinutes() {
        return totalUsageInMinutes;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public String getLINKED_ACCOUNT() {
        return LINKED_ACCOUNT;
    }

    public String getLINKED_PHONE_NUMBER() {
        return LINKED_PHONE_NUMBER;
    }
}

class Main {
    public static void main(String[] args) {
        ERyder bike1 = new ERyder("EB001", 80, true, 150.0, "user_alice", "138-0000-1234");
        bike1.ride();
        bike1.printBikeDetails();
        bike1.printRideDetails(30);

        ERyder bike2 = new ERyder("EB002", 50, false, 200.0);
        bike2.ride();
        bike2.printBikeDetails();
        bike2.printRideDetails(15);
    }
}
