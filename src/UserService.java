import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    private List<User> users;
    private List<RegisteredUsers> registeredUsersList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public UserService(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(int id) {
        users.removeIf(u -> u.getId() == id);
    }

    public User findUserById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public RegisteredUsers addNewUsers() {
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter user type (VIP/Regular): ");
        String userType = scanner.nextLine();

        RegisteredUsers newUser;
        if (userType.equalsIgnoreCase("VIP")) {
            newUser = new VIPUser(fullName, emailAddress, password, phoneNumber);
        } else {
            newUser = new RegularUser(fullName, emailAddress, password, phoneNumber);
        }
        registeredUsersList.add(newUser);
        System.out.println("User created successfully!");
        return newUser;
    }

    public List<RegisteredUsers> getRegisteredUsersList() {
        return registeredUsersList;
    }
}
