/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */

class User {
    private String username;
    private String password;

 
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

   
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


public class DisneyPlusLogin {
    private User[] users; 


    public DisneyPlusLogin() {
        
        users = new User[]{
            new User("mickeymouse", "disney123"),
            new User("donaldduck", "quackquack"),
            new User("goofy", "goofypassword")
        };
    }

    
    public boolean validateCredentials(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DisneyPlusLogin loginSystem = new DisneyPlusLogin();
        boolean isAuthenticated = false;

        // Allow the user up to 3 attempts to log in
        for (int attempts = 0; attempts < 3; attempts++) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

           
            if (loginSystem.validateCredentials(username, password)) {
                System.out.println("Login successful! Welcome to Disney Plus.");
                isAuthenticated = true;
                break;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        // If the user is not authenticated after 3 attempts, show a message
        if (!isAuthenticated) {
            System.out.println("Too many failed attempts. Please try again later.");
        }

        scanner.close();
    }
}

