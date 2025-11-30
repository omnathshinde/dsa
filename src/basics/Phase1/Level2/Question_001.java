package basics.Phase1.Level2;

import java.util.Scanner;

// Question_001 - Take three sides and check if they form a valid triangle.
public class Question_001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side 1: ");
        int a = sc.nextInt();

        System.out.print("Enter side 2: ");
        int b = sc.nextInt();

        System.out.print("Enter side 3: ");
        int c = sc.nextInt();

        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("It is a valid triangle");
        } else {
            System.out.println("It is NOT a valid triangle");
        }

        sc.close();
    }
}
