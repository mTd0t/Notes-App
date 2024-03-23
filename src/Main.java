import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        AccountList.accountsInsertArray();
        boolean loginChoiceLoop = true;
        int choice = 0;
        while (loop) { //loops for choice until user decides to exit
            loginChoiceLoop = true;
             boolean mainLoop = true;
            while (mainLoop) {
                System.out.println("************************************************************");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Accounts");
                System.out.println("4. Exit");
                System.out.println("************************************************************");
                System.out.print("\tEnter choice: ");
                choice = scan.nextInt();
                switch (choice) { //choice path1
                    case 1:
                        Authentication.register();
                        AccountList.register(); //inserts the username and password to an array for further use and login
                        mainLoop = false;
                        break;
                    case 2:
                        Authentication.login();
                        break;
                    case 3:
                        System.out.println("\t\tAccount List");
                        for (int i = 0; i <= 5; i++) { //loops the array username until it prints out everything
                            System.out.println("\t" + i + ". " + AccountList.AccountFileString.get(i).accountUsername);
                        }
                        break;
                    case 4:
                        System.exit(0); //exits program
                        break;
                    case 5:
                        System.out.println("\tInvalid input... please try again...");
                }
            }


            while (loginChoiceLoop) {
                System.out.println("************************************************************");
                System.out.println("1. Create new task");
                System.out.println("2. View all tasks");
                System.out.println("3. View task");
                System.out.println("4. Delete Task");
                System.out.println("5. Delete Account");
                System.out.println("6. Exit");
                System.out.println("************************************************************");
                System.out.print("\tEnter choice: ");
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        AccountList.AccountFileString.get(Authentication.getAccountNumberPrompt()).storeNotes();
                        break;
                    case 2:
                        AccountList.AccountFileString.get(Authentication.getAccountNumberPrompt()).displayNotes();
                        break;
                    case 3:
                        AccountList.AccountFileString.get(Authentication.getAccountNumberPrompt()).viewNote();
                        break;
                    case 4:
                        AccountList.AccountFileString.get(Authentication.getAccountNumberPrompt()).deleteNotes();
                        break;
                    case 5:
                        AccountList.AccountFileString.get(Authentication.getAccountNumberPrompt()).deleteAccount();
                        loginChoiceLoop = false;
                        break;
                    case 6:
                        loginChoiceLoop = false;
                        break;
                    default:
                        System.out.println("\tInvalid input... please try again...");
                }
            }
        }
    }
}