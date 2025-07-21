/*
A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.

Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".

Example 2:

Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".

Example 3:

Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".

Constraints:

1 <= s.length <= 105
s consists only of lowercase English letters.
*/




class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();

        int count = 1;
        result.append(s.charAt(0));

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                count++;
            } else {
                count = 1;
            }

            if(count < 3) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        String input1 = "aaabaaaa";
        String input2 = "aab";
        String input3 = "aaaabbbbcc";

        System.out.println("Result 1: " + sol.makeFancyString(input1)); // Output: "aabaa"
        System.out.println("Result 2: " + sol.makeFancyString(input2)); // Output: "aab"
        System.out.println("Result 3: " + sol.makeFancyString(input3)); // Output: "aabbcc"
    }
}