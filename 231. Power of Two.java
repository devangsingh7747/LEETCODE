/*
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.


Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1

Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16

Example 3:

Input: n = 3
Output: false


Constraints:

-231 <= n <= 231 - 1
*/




class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) {
            return false;
        }

        while(n != 1) {
            if(n % 2 != 0) {
                return false;
            }
            else {
                n /= 2;
            }
        }

        return true;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] testNumbers = {1, 2, 3, 4, 8, 16, 18, 31, 32, 64, 0, -2};

        for (int num : testNumbers) {
            System.out.println("Is " + num + " a power of two? -> " + sol.isPowerOfTwo(num));
        }
    }
}