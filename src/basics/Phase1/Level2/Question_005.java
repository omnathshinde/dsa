package basics.Phase1.Level2;

import java.util.Scanner;

// Question_005 - Take the hour of the day (0–23) and print “Good Morning”, “Good Afternoon”, “Good Evening”, or “Good Night”.
public class Question_005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the hour of the day (0-23): ");
        int hour = sc.nextInt();

        if (hour >= 0 && hour <= 23) {
            if (hour >= 5 && hour < 12) {
                System.out.println("Good Morning");
            } else if (hour >= 12 && hour < 17) {
                System.out.println("Good Afternoon");
            } else if (hour >= 17 && hour < 21) {
                System.out.println("Good Evening");
            } else {
                System.out.println("Good Night");
            }
        } else {
            System.out.println("Invalid hour! Please enter a value between 0 and 23.");
        }

        sc.close();
    }
}
