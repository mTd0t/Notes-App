import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Authentication {
    public static int accountSlot = 0;
    public static boolean mainLoop = true;
    static int accountNumberPrompt = 0;
    private static String username;
    private static String password;

    public static void register() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\tRegistration, please fill in the prompts");

        System.out.print("\tEnter your username: ");
        username = scan.nextLine();


        System.out.print("\tEnter your password: ");
        password = scan.nextLine();

        System.out.print("\tConfirm your password: ");
        String passwordConfirmation = scan.nextLine();

        while (!password.equals(passwordConfirmation)) { //checks if passwords match... prompts again if not
            System.out.println("\tError mismatched password, try again");

            System.out.println("\tError... incorrect username or password...");
            boolean errorLoop = true;
            int registerErrorChoice = 0;

            while (errorLoop) {
                try {
                    System.out.println("\t\t1. Retry");
                    System.out.println("\t\t2. Exit");
                    System.out.print("\t\tChoice: ");
                    registerErrorChoice = scan.nextInt();
                } catch (Exception e) {
                    System.out.println("\tError... Integer required...");
                } finally {
                    switch (registerErrorChoice) {
                        case 1:
                            System.out.print("\tEnter your password: ");
                            password = scan.nextLine();

                            System.out.print("\tConfirm your password: ");
                            passwordConfirmation = scan.nextLine();
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("\tInvalid input... please try again...");

                    }
                }
            }
        }
        accountNumberPrompt = accountSlot;
        AccountList.AccountFileString.add(new AccountFile());
        accountSlot++;
    }

    public static void login() {
        Scanner scan = new Scanner(System.in);
        boolean loginLoop = true;
        while (loginLoop) {
            System.out.print("\tEnter your username: ");
            username = scan.nextLine();

            System.out.print("\tEnter your password: ");
            password = scan.nextLine();


            for (int i = 0; i < accountSlot; i++) {
                if (AccountList.AccountFileString.get(i).accountUsername.equals(username)) {
                    accountNumberPrompt = i;
                }
            }
            if (username.equals(AccountList.AccountFileString.get(accountNumberPrompt).accountUsername) && password.equals(AccountList.AccountFileString.get(accountNumberPrompt).accountUsername)) {
                loginLoop = false;
                System.out.println("\tLogin successfull!");
                Choices.mainLoop = false;
            } else {
                try {
                    System.out.println("\tError... incorrect username or password...");
                    System.out.println("\t\t1. Retry");
                    System.out.println("\t\t2. Exit");
                    System.out.print("\t\tChoice: ");
                    int choice = scan.nextInt();
                    scan.nextLine();
                } catch (Exception e) {
                    System.out.println("\tError... Integer required...");
                }
            }
        }
    }

    public static int getAccountNumberPrompt() {
        return accountNumberPrompt;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}