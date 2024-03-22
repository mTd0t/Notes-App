import java.util.ArrayList;

public class AccountList {
    public static int numberOfNotes = 0;
    public static ArrayList<AccountFile> AccountFileString = new ArrayList<>();
    public static AccountFile account1 = new AccountFile();
    public static AccountFile account2 = new AccountFile();
    public static AccountFile account3 = new AccountFile();
    public static AccountFile account4 = new AccountFile();
    public static AccountFile account5 = new AccountFile();
    public static AccountFile account6 = new AccountFile();
    //arrays for usernames and passwords
    private static final String[] accountsUsername = {"", "", "", "", "", ""};
    private static final String[] accountsPassword = {"", "", "", "", "", ""};
    private static int accountCount = 0;

    public static void accountsInsertArray() {
        AccountFileString.add(account1);
        AccountFileString.add(account2);
        AccountFileString.add(account3);
        AccountFileString.add(account4);
        AccountFileString.add(account5);
        AccountFileString.add(account6);
    }


    public static String getAccount(int accountnumber) {
        return accountsUsername[accountnumber];
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public static String getAccountUsername(int num) {
        return accountsUsername[num];
    }

    public static String getAccountPassword(int num) {
        return accountsPassword[num];
    }

    public static void setAccount(String username, String password) {
        accountsUsername[Authentication.accountSlot] = username;
        accountsPassword[Authentication.accountSlot] = password;
        accountCount++;
    }

    public static void register() {
        switch (Authentication.accountSlot) {
            case 0:
                account1.accountUsername = Authentication.getUsername();
                account1.accountPassword = Authentication.getPassword();
                break;
            case 1:
                account2.accountUsername = Authentication.getUsername();
                account2.accountPassword = Authentication.getPassword();
                break;
            case 2:
                account3.accountUsername = Authentication.getUsername();
                account3.accountPassword = Authentication.getPassword();
                break;
            case 3:
                account4.accountUsername = Authentication.getUsername();
                account4.accountPassword = Authentication.getPassword();
                break;
            case 4:
                account5.accountUsername = Authentication.getUsername();
                account5.accountPassword = Authentication.getPassword();
                break;
            case 5:
                account6.accountUsername = Authentication.getUsername();
                account6.accountPassword = Authentication.getPassword();
        }
    }
}
