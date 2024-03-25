import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean loop = true;
        while (loop) { //loops for choice until user decides to exit
            while(Choices.mainLoop) {
                Choices.firstMenu(); //is the menu with register, login, view accounts etc...
                Choices.loginChoiceLoop = true;
            }
            while (Choices.loginChoiceLoop) {
                Choices.secondMenu(); //is the menu when the user is logged into an account
                Choices.mainLoop = true;
            }
        }
    }
}