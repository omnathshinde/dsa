package basics.Phase1.Level1;

import java.util.Scanner;

//  Question_001 - Take a number and print whether it's positive, negative, or zero.
public class Question_001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = sc.nextInt();

        if (number > 0) {
            System.out.println(number + " is a Positive");
        } else if (number < 0) {
            System.out.println(number + " is a Negative");
        } else {
            System.out.println("Number is Zero");
        }

        sc.close();
    }
}
