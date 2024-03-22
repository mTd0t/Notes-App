import java.util.Scanner;

public class Authentication {
    public static int accountSlot = 0;
    public static boolean mainLoop = true;
    static int accountNumberPrompt = 0;
    private static String username;
    private static String password;

    public static void register() {
        Scanner scan = new Scanner(System.in);


        System.out.println("\tAccount Slots");
        for (int i = 0; i <= 5; i++) { //loops the array username until it prints out everything
            System.out.println("\t" + i + ". " + AccountList.AccountFileString.get(i).accountUsername);
        }
        System.out.print("\tEnter account slot: ");//makes the user choose the account slot
        accountSlot = scan.nextInt();
        while (!AccountList.AccountFileString.get(accountSlot).accountUsername.isEmpty()) {//makes the user retry if account slot is taken
            System.out.println("\tError... please try again...");
            for (int i = 0; i <= 5; i++) { //loops the array username until it prints out everything
                System.out.println("\t" + i + ". " + AccountList.AccountFileString.get(i).accountUsername);
            }
            System.out.print("\tEnter account slot: ");
            accountSlot = scan.nextInt();
        }
        System.out.print("\tEnter your username: ");
        username = scan.next();

        System.out.print("\tEnter your password: ");
        password = scan.next();

        System.out.print("\tConfirm your password: ");
        String passwordConfirmation = scan.next();

        while (!password.equals(passwordConfirmation)) { //checks if passwords match... prompts again if not
            System.out.println("\tError mismatched password, try again");

            System.out.println("\tError... incorrect username or password...");
            System.out.println("\t\t1. Retry");
            System.out.println("\t\t2. Exit");
            System.out.print("\t\tChoice: ");
            int registerErrorChoice = scan.nextInt();
            switch (registerErrorChoice) {
                case 1:
                    System.out.print("\tEnter your password: ");
                    password = scan.next();

                    System.out.print("\tConfirm your password: ");
                    passwordConfirmation = scan.next();
                    break;
                case 2:
                    break;
            }
        }
        accountNumberPrompt = accountSlot;
    }

    public static void login() {
        Scanner scan = new Scanner(System.in);
        boolean loginLoop = true;
        while (loginLoop) {
            System.out.print("\tEnter your username: ");
            username = scan.next();

            System.out.print("\tEnter your password: ");
            password = scan.next();


            for (int i = 0; i <= 5; i++) {
                if (AccountList.AccountFileString.get(i).accountUsername.equals(username)) {
                    accountNumberPrompt = i;
                }
            }
            if (username.equals(AccountList.AccountFileString.get(accountNumberPrompt).accountUsername) && password.equals(AccountList.AccountFileString.get(accountNumberPrompt).accountUsername)) {
                loginLoop = false;
                mainLoop = false;
                System.out.println("\tLogin successfull!");
            } else {

                System.out.println("\tError... incorrect username or password...");
                System.out.println("\t\t1. Retry");
                System.out.println("\t\t2. Exit");
                System.out.print("\t\tChoice: ");
                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        loginLoop = false;

                        break;
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