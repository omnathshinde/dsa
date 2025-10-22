package problems;

import java.util.*;

/**
 * Problem_0242 - Valid Anagram
 * ----------------------------
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * |
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * |
 * Input: s = "rat", t = "car"
 * Output: false
 * |
 * Definition:
 * Two strings are anagrams if they contain the same characters with the same frequency.
 */
public class Problem_0004 {

    /**
     * Approach 1️⃣: Brute Force (Sorting)
     * -----------------------------------
     * Sort both strings and check if they are equal.
     * |
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) or O(n) depending on sorting implementation.
     */
    static boolean isAnagram1(String s, String t) {
        // Length mismatch → cannot be anagram
        if (s.length() != t.length()) return false;

        // Sort both strings
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        // Compare sorted results
        return Arrays.equals(sArr, tArr);
    }

    /**
     * Approach 2️⃣: Character Frequency (26 letters)
     * ----------------------------------------------
     * Since we only have lowercase English letters, we can use an array of length 26.
     * Increment for s, decrement for t → all should end at 0.
     * |
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        // __define-ocg__ Using varOcg as frequency array
        int[] varOcg = new int[26]; // for 'a' to 'z'

        for (int i = 0; i < s.length(); i++) {
            varOcg[s.charAt(i) - 'a']++;
            varOcg[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : varOcg) {
            if (count != 0) return false;
        }

        return true;
    }

    /**
     * Approach 3️⃣: HashMap Frequency Count
     * -------------------------------------
     * Works for any Unicode string (not just lowercase a–z).
     * Count frequencies for s, then subtract for t.
     * |
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> freq = new HashMap<>();

        // Count frequency of characters in s
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Subtract frequency based on characters in t
        for (char c : t.toCharArray()) {
            if (!freq.containsKey(c)) return false;
            freq.put(c, freq.get(c) - 1);
            if (freq.get(c) < 0) return false; // more t-chars than s-chars
        }

        // Optional: check all zero (not needed if above handled)
        for (int val : freq.values()) {
            if (val != 0) return false;
        }

        return true;
    }

    /**
     * Approach 4️⃣: Optimal Idea (Bit Manipulation / Early Exit)
     * ----------------------------------------------------------
     * Only valid if all characters are lowercase, and you can assume a–z.
     * For small alphabet, counting array (Approach 2) is already optimal O(n).
     * |
     * No real faster algorithm exists since you must check every character at least once.
     * However, you can exit early when mismatch found during traversal.
     */

    public static void main(String[] args) {
        System.out.println("Example 1: s = 'anagram', t = 'nagaram'");
        System.out.println("Brute Force (Sorting) → " + isAnagram1("anagram", "nagaram"));
        System.out.println("Char Frequency Array  → " + isAnagram2("anagram", "nagaram"));
        System.out.println("HashMap (General)     → " + isAnagram3("anagram", "nagaram"));

        System.out.println("\nExample 2: s = 'rat', t = 'car'");
        System.out.println("Brute Force (Sorting) → " + isAnagram1("rat", "car"));
        System.out.println("Char Frequency Array  → " + isAnagram2("rat", "car"));
        System.out.println("HashMap (General)     → " + isAnagram3("rat", "car"));
    }
}
