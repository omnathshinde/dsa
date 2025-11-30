package basics.Phase1.Level2;

import java.util.Scanner;

// Question_004 - Check if one of two given numbers is a multiple of the other
public class Question_004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        if (number1 == 0 || number2 == 0) {
            System.out.println("One of the numbers is zero, cannot check multiples.");
        } else if (number1 % number2 == 0) {
            System.out.println(number1 + " is a multiple of " + number2);
        } else if (number2 % number1 == 0) {
            System.out.println(number2 + " is a multiple of " + number1);
        } else {
            System.out.println("Neither number is a multiple of the other");
        }

        sc.close();
    }
}
