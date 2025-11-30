package basics.Phase1.Level1;

import java.util.Scanner;

// Question_008 - Take a temperature value and print “Cold”, “Warm”, or “Hot” using range conditions.
public class Question_008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature: ");
        int temperature = sc.nextInt();

        if (temperature < 20) {
            System.out.println("Cold");
        } else if (temperature < 35) {
            System.out.println("Warm");
        } else {
            System.out.println("Hot");
        }

        sc.close();
    }
}
