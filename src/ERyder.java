//ERyder.java
public class ERyder {
    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    public ERyder() {
        this.bikeID = "DEFAULT_ID";
        this.batteryLevel = 100;
        this.isAvailable = true;
        this.kmDriven = 0.0;
    }

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeID = bikeID;
        setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
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
}

// Main.java
public class Main {
    public static void main(String[] args) {
        ERyder bike1 = new ERyder();
        bike1.printBikeDetails();
        ERyder bike2 = new ERyder("EB001", 75, true, 125.5);
        bike2.ride();
        bike2.printBikeDetails();

        ERyder bike3 = new ERyder("EB002", 0, true, 200.0);
        bike3.ride();
        bike3.printBikeDetails();
    }
}
