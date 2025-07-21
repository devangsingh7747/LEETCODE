/*
Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.


Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.
*/




class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                res++;
            }
            else if(res > 0) {
                return res;
            }
        }

        return res;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        String input1 = "Hello World";
        String input2 = "   fly me   to   the moon  ";
        String input3 = "luffy is still joyboy";

        System.out.println("Length of last word (input1): " + sol.lengthOfLastWord(input1));    // Output: 5
        System.out.println("Length of last word (input2): " + sol.lengthOfLastWord(input2));    // Output: 4
        System.out.println("Length of last word (input3): " + sol.lengthOfLastWord(input3));    // Output: 6
    }
}