import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Netflix netflix = new Netflix();
        netflix.add_tv_show();
        Account user = authentication(netflix);
        if (user == null) {
            return;
        } menu(netflix, user);
    }

    public static Account authentication(Netflix netflix) {
        int option;
        String userName, password;
        Account user = new Account();
        while (true) {
            try {
                System.out.println("1.Sign in");
                System.out.println("2.Sign up");
                option = scanner.nextInt();
                switch (option) {

                    case 1:
                        System.out.print("Please enter user name: ");
                        userName = scanner.next();
                        System.out.print("Please enter password: ");
                        password = scanner.next();
                        user = netflix.login(userName, password);
                        if (user != null) {
                            return user;
                        }
                        System.out.println("User name or password is not correct");
                        break;

                    case 2:
                        System.out.print("Please insert user name: ");
                        userName = scanner.next();
                        if (netflix.checkUserName(userName)) {
                            user = SignUp.sign_up(userName);
                            return user;
                        }
                        break;
                    default:
                        break;
                }
            } catch (Exception exception) {
                System.out.println("only 1/2");
                scanner.nextLine();
            }
        }
    }

    public static void menu(Netflix netflix, Account user) {
        int choice;
        boolean runMenu = true;
        while(runMenu) {
            try {
                System.out.println("1.List all our tv shows");
                System.out.println("2.List all tv shows you started watching");
                System.out.println("3.View membership details");
                System.out.println("4.Choose tv show to watch");
                System.out.println("5.Log out");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        netflix.displayAllTvSeries();
                        break;

                    case 2:
                        user.displayWatchedSeries();
                        break;

                    case 3:
                        user.memberDetails();
                        break;

                    case 4:
                        System.out.println("Enter TV show you want to watch:");
                        String showName = scanner.next();
                        netflix.watchTvSeries(showName, user);
                        break;

                    case 5:
                        runMenu = false;
                        break;

                    default:
                        break;
                }
            } catch (Exception exception) {
                System.out.println("only 1/2/3/4/5");
                scanner.nextLine();
            }
        }
    }
}