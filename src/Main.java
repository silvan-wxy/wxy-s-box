public class Main {
    public static void main(String[] args) {
        BikeDatabase bikeDatabase = new BikeDatabase();
        BikeService bikeService = new BikeService(bikeDatabase);
        AdminPanel adminPanel = new AdminPanel(bikeService);
        adminPanel.showAdminMenu();
    }
}
