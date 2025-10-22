package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem_0217 - Contains Duplicate
 * |
 * Given an integer array numbers, return true if any value appears
 * at least twice in the array, and false if every element is distinct.
 * |
 * Example:
 * Input: numbers = [1,2,3,1]
 * Output: true
 * |
 * Approaches:
 * 1️⃣ Brute Force  → O(n²)
 * 2️⃣ Sorting       → O(n log n)
 * 3️⃣ HashSet       → O(n)
 */
public class Problem_0002 {

    /**
     * Approach 1: Brute Force
     * Compare each pair of elements using nested loops.
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    static boolean containsDuplicate1(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach 2: Use Sorting.
     * Sort the array and check adjacent elements for duplicates.
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) or O(n) (depending on sort implementation)
     */
    static boolean containsDuplicate2(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Approach 3: HashSet
     * Use a HashSet to track seen elements.
     * If an element is already in the set, duplicate found.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static boolean containsDuplicate3(int[] numbers) {
        // HashSet approach — best optimal solution
        Set<Integer> set = new HashSet<>();

        for (int num : numbers) {
            if (set.contains(num)) {
                return true; // Duplicate found
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3, 1};
        int[] numbers2 = {1, 2, 3, 4};
        int[] numbers3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println("Example 1:");
        System.out.println("Brute Force → " + containsDuplicate1(numbers1));
        System.out.println("Sorting     → " + containsDuplicate2(numbers1));
        System.out.println("HashSet     → " + containsDuplicate3(numbers1));

        System.out.println("\nExample 2:");
        System.out.println("Brute Force → " + containsDuplicate1(numbers2));
        System.out.println("Sorting     → " + containsDuplicate2(numbers2));
        System.out.println("HashSet     → " + containsDuplicate3(numbers2));

        System.out.println("\nExample 3:");
        System.out.println("Brute Force → " + containsDuplicate1(numbers3));
        System.out.println("Sorting     → " + containsDuplicate2(numbers3));
        System.out.println("HashSet     → " + containsDuplicate3(numbers3));
    }
}
