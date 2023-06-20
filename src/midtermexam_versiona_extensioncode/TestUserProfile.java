import java.util.Scanner;

public class TestUserProfile {
    private User users[] = new User[100]; // room for 100 online players!

    public static void main(String[] args) {
        TestUserProfile userProfile = new TestUserProfile();
        userProfile.run();
    }
    private void run() {
        int userCount = 0; // keep track of number of users for array
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your desired username:");
        String userName = sc.nextLine();

        boolean validPassword = false;
        String password = "";

        while (!validPassword) {
            System.out.println("Passwords must have at least 8 characters");
            System.out.println("Passwords must have at least one special character");
            System.out.println("Please enter your desired password:");

            password = sc.nextLine();
            int specialCharCount = 0;

            // iterate over each character to see if it is a special character
            for (int i = 0; i < password.length(); i++) {
                if (!(Character.isLetterOrDigit(password.charAt(i)))) {
                    // now we know there is at least one special character
                    specialCharCount++;
                }
            }

            if (specialCharCount > 0 && password.length() > 7) {
                validPassword = true;
            }
        }

        User newUser = new User(userName, password);
        users[userCount] = newUser; // add the new user to the user list
        userCount++;

        System.out.println("New User Added");
        System.out.println("UserName: " + userName);
        System.out.println("Password: (hidden)");
        
        chooseFavoriteGenre(newUser);
    }

    private void chooseFavoriteGenre(User user) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nChoose your favorite genre from the list:");
        System.out.println("1. Action");
        System.out.println("2. Adventure");
        System.out.println("3. Comedy");
        System.out.println("4. Drama");
        System.out.println("5. Fantasy");
        
        int choice = sc.nextInt();
        String genre = "";
        
        switch (choice) {
            case 1:
                genre = "Action";
                break;
            case 2:
                genre = "Adventure";
                break;
            case 3:
                genre = "Comedy";
                break;
            case 4:
                genre = "Drama";
                break;
            case 5:
                genre = "Fantasy";
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                chooseFavoriteGenre(user);
                return;
        }
        user.FavoriteGenre(genre);
        System.out.println("Your user profile was created!");
        System.out.println("Favorite Genre: " + genre);
    }
}