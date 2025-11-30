package basics.Phase1.Level2;

import java.util.Scanner;

// Question_006 - Check voting eligibility for a given age (18+)
public class Question_006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        if (age >= 18) {
            System.out.println("Eligible for voting");
        } else {
            System.out.println("Not Eligible for voting");
        }

        sc.close();
    }
}
