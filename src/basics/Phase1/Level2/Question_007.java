package basics.Phase1.Level2;

import java.util.Scanner;

// Question_007 - Take two numbers and determine whether both are even, both are odd, or one is even and one is odd
public class Question_007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        if (a % 2 == 0 && b % 2 == 0) {
            System.out.println(a + " and " + b + " are both even");
        } else if (a % 2 != 0 && b % 2 != 0) {
            System.out.println(a + " and " + b + " are both odd");
        } else {
            System.out.println("One number is even and the other is odd");
        }

        sc.close();
    }
}
