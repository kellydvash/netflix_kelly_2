import java.util.Scanner;

public class SignUp {
    private static Scanner scanner = new Scanner(System.in);

    public static Account sign_up(String userName) {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        String password = createPassword();
        Account newUser = new Account(name, userName, password, 12);
        return newUser;
    }

    public static String createPassword() {
        String password = "";
        int Password1 = 0, Password2 = 0;
        System.out.println("Please enter password:");
        boolean isStrong = false;
        do { System.out.println("(Password should be at least 6 characters - at least one english letter and one digit)");
            password = scanner.next();
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    Password1++;
                }
                if (Character.isAlphabetic(password.charAt(i))) {
                    Password2++; }
                if (Password1 > 0 && Password2 > 0 && password.length() > 5) {
                    isStrong = true;
                    break;
                }
            }
        } while (!isStrong);
        return password;
    }
}