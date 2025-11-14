import java.util.Scanner;

public class Q3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        /* to validate the username */
        String validUsername = "^[A-Za-z][a-z0-9_]{4,14}$";
        if (!username.matches(validUsername)) {
            System.out.println("Invalid username");
        } else { // for valid username
            /* password validation */
            int strength = 0;
            int length = password.length();

            if (length >= 8) { // minimum 8 characters
                strength++;
            }
            if (password.matches(".*[A-Z].*")) { // at least one uppercase letter
                strength++;
            }
            if (password.matches(".*[a-z].*")) { // at least one lowercase letter
                strength++;
            }
            if (password.matches(".*[0-9].*")) { // at least one digit
                strength++;
            }
            if (password.matches(".*[!@#$%^&*].*")) { // at least one special character
                strength++;
            }
            if (!password.contains(" ")) { // must not contain spaces
                strength++;
            }
            if (!password.toLowerCase().contains(username.toLowerCase())) { // no username as a substring
                strength++;
            }

            if (strength <= 3) {
                System.out.println("Password Strength: Weak");
            } else if (strength <= 5) {
                System.out.println("Password Strength: Moderate");
            } else if (strength == 6) {
                System.out.println("Password Strength: Strong");
            } else {
                System.out.println("Password Strength: Very Strong");
            }
        }
    }
}