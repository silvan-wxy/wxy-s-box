import java.time.LocalDateTime;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

public class BikeService {
    private BikeDatabase bikeDatabase;
    private Stack<ERyderLog> logStack = new Stack<>();
    private Queue<BikeRequest> bikeRequest = new ArrayDeque<>();
    private int logCounter = 1;

    public BikeService(BikeDatabase bikeDatabase) {
        this.bikeDatabase = bikeDatabase;
    }

    public boolean checkLocationValid(String location) {
        return bikeDatabase.isValidLocation(location);
    }

    public Bike findAvailableBike(String location) {
        return bikeDatabase.getAvailableBike(location);
    }

    public void markBikeAsRented(Bike bike) {
        bike.setRented(true);
        String logId = "BR" + logCounter++;
        String event = "Bike with " + bike.getBikeID() + " was rented by " + bike.getLinkedAccount() + " from location " + bike.getLocation();
        LocalDateTime now = LocalDateTime.now();
        ERyderLog log = new ERyderLog(logId, event, now);
        logStack.push(log);

        String tripStartId = "TS" + logCounter++;
        String tripStartEvent = "Trip started with bike " + bike.getBikeID() + " by " + bike.getLinkedAccount() + " from " + bike.getLocation();
        LocalDateTime startNow = LocalDateTime.now();
        ERyderLog startLog = new ERyderLog(tripStartId, tripStartEvent, startNow);
        logStack.push(startLog);
    }

    public void returnBike(Bike bike) {
        bike.setRented(false);
        String logId = "TE" + logCounter++;
        String event = "Trip ended with bike " + bike.getBikeID() + " by " + bike.getLinkedAccount() + " at " + bike.getLocation();
        LocalDateTime now = LocalDateTime.now();
        ERyderLog log = new ERyderLog(logId, event, now);
        logStack.push(log);

        if (!bikeRequest.isEmpty()) {
            BikeRequest nextRequest = bikeRequest.poll();
            Bike availableBike = findAvailableBike(nextRequest.getLocation());
            if (availableBike != null) {
                markBikeAsRented(availableBike);
            }
        }
    }

    public void addBikeRequest(String userEmail, String location) {
        LocalDateTime requestTime = LocalDateTime.now();
        BikeRequest request = new BikeRequest(userEmail, location, requestTime);
        bikeRequest.add(request);
    }

    public void viewSystemLogs() {
        System.out.println("\n===== System Logs =====");
        if (logStack.isEmpty()) {
            System.out.println("No logs available");
            return;
        }
        for (ERyderLog log : logStack) {
            System.out.println(log);
        }
    }

    public Queue<BikeRequest> getBikeRequestQueue() {
        return bikeRequest;
    }
}
