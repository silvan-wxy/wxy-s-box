import java.util.Scanner;
import java.util.Queue;

public class AdminPanel {
    private BikeService bikeService;
    private Scanner scanner;

    public AdminPanel(BikeService bikeService) {
        this.bikeService = bikeService;
        this.scanner = new Scanner(System.in);
    }

    public void showAdminMenu() {
        while (true) {
            System.out.println("\nAdmin Panel");
            System.out.println("1. View System Logs");
            System.out.println("2. Manage Pending Bike Requests");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bikeService.viewSystemLogs();
                    break;
                case 2:
                    managePendingRequests();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void managePendingRequests() {
        while (true) {
            System.out.println("\nManage Pending Bike Requests");
            System.out.println("1. View Queue");
            System.out.println("2. Update Queue");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewRequestQueue();
                    break;
                case 2:
                    updateRequestQueue();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void viewRequestQueue() {
        Queue<BikeRequest> queue = bikeService.getBikeRequestQueue();
        if (queue.isEmpty()) {
            System.out.println("No pending requests");
            return;
        }
        for (BikeRequest request : queue) {
            System.out.println(request);
        }
    }

    private void updateRequestQueue() {
        Queue<BikeRequest> queue = bikeService.getBikeRequestQueue();
        if (queue.isEmpty()) {
            System.out.println("No pending requests to remove");
            return;
        }
        queue.poll();
        System.out.println("Removed first pending request");
    }
}
