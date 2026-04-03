public class RegularUser extends RegisteredUsers {
    public RegularUser(String fullName, String emailAddress, String password, String phoneNumber) {
        super(fullName, emailAddress, password, phoneNumber);
    }

    public double calculateFare(double baseFare) {
        return baseFare;
    }

    public void displayUserType() {
        System.out.println("Regular User");
    }
}
