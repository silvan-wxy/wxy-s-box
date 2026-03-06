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
        System.out.println("Is Available: " + isAvailable);
        System.out.println("Total Distance Driven: " + kmDriven + " km");
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
            System.out.println("Error: Battery level must be between 0 and 100. Setting to default (100).");
            this.batteryLevel = 100;
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
