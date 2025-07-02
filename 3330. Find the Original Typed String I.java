/*
Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.

Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.

You are given a string word, which represents the final output displayed on Alice's screen.

Return the total number of possible original strings that Alice might have intended to type.


Example 1:

Input: word = "abbcccc"

Output: 5

Explanation:

The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".

Example 2:

Input: word = "abcd"

Output: 1

Explanation:

The only possible string is "abcd".

Example 3:

Input: word = "aaaa"

Output: 4


Constraints:

1 <= word.length <= 100
word consists only of lowercase English letters.
*/







class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int count = 0;

        for(int i = 1; i < n; i++) {
            if(word.charAt(i) == word.charAt(i - 1)) {
                count++;
            }
        }

        return count + 1;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample test cases
        String test1 = "aabbcc";     // Expected output: 3 + 1 = 4
        String test2 = "abcde";      // Expected output: 0 + 1 = 1
        String test3 = "aaa";        // Expected output: 2 + 1 = 3
        String test4 = "ababab";     // Expected output: 0 + 1 = 1

        System.out.println("Test 1 Output: " + solution.possibleStringCount(test1));
        System.out.println("Test 2 Output: " + solution.possibleStringCount(test2));
        System.out.println("Test 3 Output: " + solution.possibleStringCount(test3));
        System.out.println("Test 4 Output: " + solution.possibleStringCount(test4));
    }
}