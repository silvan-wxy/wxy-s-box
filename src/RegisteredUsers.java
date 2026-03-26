import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {
    private List<RegisteredUsers> registeredUsersList;
    private Scanner scanner;

    public AdminPanel() {
        registeredUsersList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void userManagementOptions() {
        while (true) {
            System.out.println("Welcome to E-Ryder Administrator Panel.");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Invalid choice. Please try again\n");
                continue;
            }

            switch (choice) {
                case 1:
                    addNewUsers();
                    break;
                case 2:
                    viewRegisteredUsers();
                    break;
                case 3:
                    removeRegisteredUsers();
                    break;
                case 4:
                    updateRegisteredUsers();
                    break;
                case 5:
                    System.out.println("Exiting Admin Panel...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again\n");
            }
        }
    }

    private void addNewUsers() {
        System.out.print("How many users would you like to add? ");
        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < num; i++) {
            System.out.println("\n--- Enter details for User " + (i + 1) + " ---");
            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();
            System.out.print("Email Address: ");
            String email = scanner.nextLine();
            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine();
            System.out.print("Card Number: ");
            String cardNum = scanner.nextLine();
            System.out.print("Card Expiry Date: ");
            String cardExp = scanner.nextLine();
            System.out.print("Card Provider: ");
            String cardPro = scanner.nextLine();
            System.out.print("CVV: ");
            String cvv = scanner.nextLine();
            System.out.print("User Type: ");
            String userType = scanner.nextLine();

            String[] lastThreeTrips = new String[3];
            for (int j = 0; j < 3; j++) {
                System.out.println("\n--- Enter Trip " + (j + 1) + " Details ---");
                System.out.print("Trip Date (YYYY-MM-DD): ");
                String tripDate = scanner.nextLine();
                System.out.print("Source and Destination: ");
                String srcDest = scanner.nextLine();
                System.out.print("Fare: ");
                String fare = scanner.nextLine();
                lastThreeTrips[j] = tripDate + " | " + srcDest + " | Fare: " + fare;
            }

            RegisteredUsers user = new RegisteredUsers(fullName, email, dob, cardNum, cardExp, cardPro, cvv, userType, lastThreeTrips);
            registeredUsersList.add(user);
            System.out.println("User added successfully!");
        }
    }

    private void viewRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users.");
            return;
        }
        System.out.println("\n--- Registered Users ---");
        for (RegisteredUsers user : registeredUsersList) {
            System.out.println(user);
        }
    }

    private void removeRegisteredUsers() {
        System.out.print("Enter user email to remove: ");
        String email = scanner.nextLine();
        Iterator<RegisteredUsers> iterator = registeredUsersList.iterator();
        boolean removed = false;

        while (iterator.hasNext()) {
            RegisteredUsers user = iterator.next();
            if (user.getEmailAddress().equals(email)) {
                iterator.remove();
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("User removed successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    private void updateRegisteredUsers() {
        System.out.print("Enter user email to update: ");
        String email = scanner.nextLine();

        for (RegisteredUsers user : registeredUsersList) {
            if (user.getEmailAddress().equals(email)) {
                System.out.print("Enter new Full Name: ");
                user.setFullName(scanner.nextLine());
                System.out.print("Enter new User Type: ");
                user.setUserType(scanner.nextLine());
                System.out.println("User updated successfully.");
                return;
            }
        }
        System.out.println("User not found.");
    }
}

class RegisteredUsers {
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private String cardNumber;
    private String cardExpiryDate;
    private String cardProvider;
    private String cvv;
    private String userType;
    private String[] lastThreeTrips;

    public RegisteredUsers(String fullName, String emailAddress, String dateOfBirth,
                           String cardNumber, String cardExpiryDate, String cardProvider,
                           String cvv, String userType, String[] lastThreeTrips) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.cardNumber = cardNumber;
        this.cardExpiryDate = cardExpiryDate;
        this.cardProvider = cardProvider;
        this.cvv = cvv;
        this.userType = userType;
        this.lastThreeTrips = lastThreeTrips;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
    public String getCardExpiryDate() { return cardExpiryDate; }
    public void setCardExpiryDate(String cardExpiryDate) { this.cardExpiryDate = cardExpiryDate; }
    public String getCardProvider() { return cardProvider; }
    public void setCardProvider(String cardProvider) { this.cardProvider = cardProvider; }
    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }
    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }
    public String[] getLastThreeTrips() { return lastThreeTrips; }
    public void setLastThreeTrips(String[] lastThreeTrips) { this.lastThreeTrips = lastThreeTrips; }

    @Override
    public String toString() {
        return "RegisteredUsers{" +
                "fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardExpiryDate='" + cardExpiryDate + '\'' +
                ", cardProvider='" + cardProvider + '\'' +
                ", cvv='" + cvv + '\'' +
                ", userType='" + userType + '\'' +
                ", lastThreeTrips=" + Arrays.toString(lastThreeTrips) +
                '}';
    }
}
