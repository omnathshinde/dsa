package basics.Phase1.Level2;

import java.util.Scanner;

// Question_008 - Take an alphabet character and check if it lies between ‘a’ and ‘m’ or ‘n’ and ‘z’
public class Question_008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        if ((ch >= 'a' && ch <= 'm') || (ch >= 'n' && ch <= 'z')) {
            System.out.println("Character lies between ‘a’ and ‘m’ or ‘n’ and ‘z’");
        } else {
            System.out.println("Character does not lie between ‘a’ and ‘m’ or ‘n’ and ‘z’");
        }

        sc.close();
    }
}
