import java.util.ArrayList;
import java.util.Scanner;

public class AccountFile {
    public static ArrayList<String> notesTitleList = new ArrayList<>();
    public static ArrayList<String> notesContentList = new ArrayList<>();
    public static ArrayList<String> notesDeadlineList = new ArrayList<>();
    public String accountUsername = "";
    public String accountPassword = "";
    int numberOfNotes = 0;

    public void setAccountUsername(String username){
        accountUsername = username;
    }
    public void setAccountPassword(String username){
        accountUsername = username;
    }
    public void storeNotes() {
        Scanner scan = new Scanner(System.in);

        System.out.print("\tEnter note title: ");
        String noteTitle = scan.nextLine();

        System.out.print("\tEnter note content: ");
        String noteContent = scan.nextLine();

        System.out.print("\tEnter note deadline: ");
        String noteDeadline = scan.nextLine();
        notesTitleList.add(noteTitle);
        notesContentList.add(noteContent);
        notesDeadlineList.add(noteDeadline);
        numberOfNotes++;
    }

    public void displayNotes() {
        System.out.println("\t\tNotes: ");
        for (int i = 0; i < numberOfNotes; i++) {
            System.out.println("\t" + i + ". " + notesTitleList.get(i) + " Deadline: " + notesDeadlineList.get(i));
        }
    }
    public void viewNote(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\t\tNotes: ");
        for (int i = 0; i < numberOfNotes; i++) {
            System.out.println("\t" + i + ". " + notesTitleList.get(i) + " Deadline: " + notesDeadlineList.get(i));
        }
        System.out.print("\tEnter task number to view: ");
        int choice = scan.nextInt();
        scan.nextLine();

        System.out.println();

        System.out.println("\t"+notesTitleList.get(choice));
        System.out.println("\t"+notesContentList.get(choice));
        System.out.println("\t"+notesDeadlineList.get(choice));
        System.out.println();
    }
    public void deleteNotes() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\t\tNotes: ");
        for (int i = 0; i < numberOfNotes; i++) {
            System.out.println("\t" + i + ". " + notesTitleList.get(i) + " Deadline: " + notesDeadlineList.get(i));
        }
        System.out.print("\tEnter task number to delete: ");
        int notesNumber = scan.nextInt();
        notesTitleList.remove(notesNumber);
        notesContentList.remove(notesNumber);
        notesDeadlineList.remove(notesNumber);
        numberOfNotes--;
    }

    public void deleteAccount() {
        notesTitleList.removeAll(notesTitleList);
        notesContentList.removeAll(notesDeadlineList);
        notesDeadlineList.removeAll(notesDeadlineList);
        accountUsername = "";
        accountPassword = "";
        System.out.println("\tDeletion Complete!");
    }
}
