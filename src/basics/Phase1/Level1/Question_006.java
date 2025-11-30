package basics.Phase1.Level1;

import java.util.Scanner;

// Question_006 - Take two numbers and print the larger one.
public class Question_006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        if (number1 > number2) {
            System.out.println(number1 + " is larger");
        } else if (number2 > number1) {
            System.out.println(number2 + " is larger");
        } else {
            System.out.println("Both numbers are equal");
        }

        sc.close();
    }
}
