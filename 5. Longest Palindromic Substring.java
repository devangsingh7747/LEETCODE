/*
Given a string s, return the longest palindromic substring in s.


Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/



class Solution {
    int max = 0, start = 0, end = 0;

    public boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            if(ch1 != ch2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isPalindrome(s, i, j) == true) {
                    if((j - i + 1) > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        String[] testStrings = {"babad", "cbbd", "a", "ac", "racecar", "banana"};

        for (String s : testStrings) {
            System.out.println("Longest Palindromic Substring in \"" + s + "\": " + sol.longestPalindrome(s));
        }
    }
}