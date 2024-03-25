import java.util.ArrayList;

public class AccountList {
    public static int numberOfNotes = 0;
    public static ArrayList<AccountFile> AccountFileString = new ArrayList<>();

    //arrays for usernames and passwords
    public static int accountCount = 0;

    public static void register() {
        AccountFileString.add(new AccountFile());
        AccountFileString.get(accountCount).setAccountUsername(Authentication.getUsername());
        AccountFileString.get(accountCount).setAccountPassword(Authentication.getPassword());
        accountCount++;
    }
}
