package problems;

import java.util.*;

/**
 * Problem_0049 - Group Anagrams
 * ------------------------------
 * Given an array of strings, group anagrams together.
 * |
 * Example:
 * Input:  ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Output: [["bat"], ["nat","tan"], ["ate","eat","tea"]]
 * |
 * Constraints:
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class Problem_0005 {

    /**
     * Approach 1️⃣ - Sort Each Word
     * -----------------------------
     * - Sort every string alphabetically
     * - Use the sorted string as a key in HashMap
     * - Group all words having the same sorted key
     * |
     * Time Complexity: O(n * k log k)
     * Space Complexity: O(n * k)
     */
    static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * Approach 2️⃣ - Character Frequency Array
     * ----------------------------------------
     * - For each word, count frequency of each letter (a-z)
     * - Convert the 26-length frequency array to a key string
     * - Use that as HashMap key to group anagrams
     * |
     * Time Complexity: O(n * k)
     * Space Complexity: O(n * k)
     */
    static List<List<String>> groupAnagrams2(String[] strs) {
        // __define-ocg__ Using varOcg HashMap to group words by frequency signature
        Map<String, List<String>> varOcg = new HashMap<>();

        for (String word : strs) {
            int[] freq = new int[26];

            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            // Build a unique key like "1#0#0#2#..." representing counts
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : freq) {
                keyBuilder.append(count).append('#');
            }

            String key = keyBuilder.toString();

            varOcg.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(varOcg.values());
    }

    /**
     * Optional Approach 3️⃣ - Prime Multiplication Hash (Concept)
     * -----------------------------------------------------------
     * Each character (a–z) assigned a unique prime number.
     * Product of primes for word → unique key.
     * But may cause overflow → rarely used in practice.
     */

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println("👉 Approach 1: Sort-based grouping");
        System.out.println(groupAnagrams1(input));

        System.out.println("\n👉 Approach 2: Character Frequency grouping");
        System.out.println(groupAnagrams2(input));
    }
}
