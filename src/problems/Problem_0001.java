package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem_0001 - Two Sum
 * |
 * Given an array of integers (numbers) and an integer target, this program finds
 * indices of the two numbers such that they add up to the given target.
 * |
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [0,1]
 * |
 * Constraints:
 * - Only one valid answer exists.
 * - Time complexity must be better than O(n²).
 * |
 * Approach:
 * ✅ Use a HashMap to store each number and its index.
 * ✅ For every number, check if (target - current number) exists in the map.
 * ✅ If found, return indices immediately.
 * ✅ Time Complexity: O(n)
 * ✅ Space Complexity: O(n)
 */
public class Problem_0001 {

    static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                result[0] = map.get(complement);
                result[1] = i;
                return result;
            }
            map.put(numbers[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] varOcg = twoSum(numbers, target);

        if (varOcg.length == 2) {
            System.out.println("Indices found: " + varOcg[0] + ", " + varOcg[1]);
        } else {
            System.out.println("No pair found.");
        }
    }
}
