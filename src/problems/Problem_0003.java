package problems;

import java.util.*;

/**
 * Problem_0219 - Contains Duplicate II
 * |
 * Given an integer array numbs and an integer k,
 * return true if there are two distinct indices i and j
 * such that numbs[i] == numbs[j] and abs(i - j) <= k.
 * |
 * Example:
 * Input: numbs = [1,2,3,1], k = 3
 * Output: true
 * |
 * Approaches Implemented:
 * 1️⃣ Brute Force        - O(n * k)
 * 2️⃣ HashMap            - O(n)
 * 3️⃣ HashSet Sliding Window - O(n)
 * 4️⃣ TreeSet Binary Search  - O(n log k)
 */
public class Problem_0003 {

    /**
     * Approach 1️⃣: Brute Force
     * -------------------------
     * For each element, check the next 'k' elements for duplicates.
     * |
     * Time Complexity: O(n * k)
     * Space Complexity: O(1)
     */
    static boolean containsNearbyDuplicate1(int[] numbs, int k) {
        for (int i = 0; i < numbs.length; i++) {
            // Compare each element with the next k elements
            for (int j = i + 1; j <= i + k && j < numbs.length; j++) {
                if (numbs[i] == numbs[j]) {
                    return true; // Found duplicate within range
                }
            }
        }
        return false; // No duplicates found within k distance
    }

    /**
     * Approach 2️⃣: HashMap
     * ---------------------
     * Store the last index of each number.
     * If we find the same number again, check index difference <= k.
     * |
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static boolean containsNearbyDuplicate2(int[] numbs, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // num → last index

        for (int i = 0; i < numbs.length; i++) {
            if (map.containsKey(numbs[i])) {
                int lastIndex = map.get(numbs[i]);
                // Check distance between indices
                if (i - lastIndex <= k) {
                    return true;
                }
            }
            // Update last seen index of current number
            map.put(numbs[i], i);
        }

        return false; // No duplicates found within k distance
    }

    /**
     * Approach 3️⃣: HashSet Sliding Window
     * ------------------------------------
     * Maintain a sliding window of the last 'k' elements.
     * If the new element is already in the window → duplicate found.
     * |
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    static boolean containsNearbyDuplicate3(int[] numbs, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbs.length; i++) {
            // Check if duplicate exists in window
            if (set.contains(numbs[i])) {
                return true;
            }

            // Add current element to the set
            set.add(numbs[i]);

            // Maintain window size = k
            if (set.size() > k) {
                set.remove(numbs[i - k]);
            }
        }

        return false; // No duplicates found
    }

    /**
     * Approach 4️⃣: TreeSet (Binary Search Based)
     * -------------------------------------------
     * Use TreeSet (a balanced BST) to maintain elements in sorted order.
     * Each insert/remove/search takes O(log k).
     * |
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     */
    static boolean containsNearbyDuplicate4(int[] numbs, int k) {
        TreeSet<Integer> tree = new TreeSet<>();

        for (int i = 0; i < numbs.length; i++) {
            // Check if the same element already exists in the TreeSet
            Integer floor = tree.floor(numbs[i]);   // largest <= numbs[i]
            Integer ceil = tree.ceiling(numbs[i]);  // smallest >= numbs[i]

            if ((floor != null && floor.equals(numbs[i])) ||
                    (ceil != null && ceil.equals(numbs[i]))) {
                return true; // Found duplicate
            }

            // Add current element to TreeSet
            tree.add(numbs[i]);

            // Keep only k elements in window
            if (tree.size() > k) {
                tree.remove(numbs[i - k]);
            }
        }

        return false; // No duplicates within k distance
    }

    // 🔹 Main function to test all approaches
    public static void main(String[] args) {
        int[] numbs1 = {1, 2, 3, 1};
        int[] numbs2 = {1, 0, 1, 1};
        int[] numbs3 = {1, 2, 3, 1, 2, 3};

        int k1 = 3, k2 = 1, k3 = 2;

        System.out.println("Example 1: numbs = [1,2,3,1], k = 3");
        System.out.println("Brute Force  → " + containsNearbyDuplicate1(numbs1, k1));
        System.out.println("HashMap      → " + containsNearbyDuplicate2(numbs1, k1));
        System.out.println("HashSet SW   → " + containsNearbyDuplicate3(numbs1, k1));
        System.out.println("TreeSet (O(n log k)) → " + containsNearbyDuplicate4(numbs1, k1));

        System.out.println("\nExample 2: numbs = [1,0,1,1], k = 1");
        System.out.println("Brute Force  → " + containsNearbyDuplicate1(numbs2, k2));
        System.out.println("HashMap      → " + containsNearbyDuplicate2(numbs2, k2));
        System.out.println("HashSet SW   → " + containsNearbyDuplicate3(numbs2, k2));
        System.out.println("TreeSet (O(n log k)) → " + containsNearbyDuplicate4(numbs2, k2));

        System.out.println("\nExample 3: numbs = [1,2,3,1,2,3], k = 2");
        System.out.println("Brute Force  → " + containsNearbyDuplicate1(numbs3, k3));
        System.out.println("HashMap      → " + containsNearbyDuplicate2(numbs3, k3));
        System.out.println("HashSet SW   → " + containsNearbyDuplicate3(numbs3, k3));
        System.out.println("TreeSet (O(n log k)) → " + containsNearbyDuplicate4(numbs3, k3));
    }
}
