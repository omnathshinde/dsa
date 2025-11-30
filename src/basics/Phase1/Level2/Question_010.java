package basics.Phase1.Level2;

import java.util.Scanner;

// Question_010 - Take a month number (1–12) and print the number of days in that month (ignore leap years).
public class Question_010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month number (1-12): ");
        int month = sc.nextInt();

        switch (month) {
            case 1:  // Jan
            case 3:  // Mar
            case 5:  // May
            case 7:  // Jul
            case 8:  // Aug
            case 10: // Oct
            case 12: // Dec
                System.out.println("31 days");
                break;

            case 4:  // Apr
            case 6:  // Jun
            case 9:  // Sep
            case 11: // Nov
                System.out.println("30 days");
                break;

            case 2:  // Feb
                System.out.println("28 days");
                break;

            default:
                System.out.println("Invalid month number! Please enter 1–12.");
        }

        sc.close();
    }
}
