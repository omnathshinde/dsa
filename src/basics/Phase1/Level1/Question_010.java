package basics.Phase1.Level1;

import java.util.Scanner;

// Question_010 - Take a character and check whether it’s uppercase, lowercase, a digit, or a special character.
public class Question_010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        if (ch >= 'A' && ch <= 'Z') {
            System.out.println(ch + " is an Uppercase letter");
        }
        else if (ch >= 'a' && ch <= 'z') {
            System.out.println(ch + " is a Lowercase letter");
        }
        else if (ch >= '0' && ch <= '9') {
            System.out.println(ch + " is a Digit");
        }
        else {
            System.out.println(ch + " is a Special Character");
        }

        sc.close();
    }
}
