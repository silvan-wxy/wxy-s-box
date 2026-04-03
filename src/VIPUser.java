public class VIPUser extends RegisteredUsers {
    public VIPUser(String fullName, String emailAddress, String password, String phoneNumber) {
        super(fullName, emailAddress, password, phoneNumber);
    }

    public double calculateFare(double baseFare) {
        return baseFare * 0.8;
    }

    public void displayUserType() {
        System.out.println("VIP User");
    }
}
