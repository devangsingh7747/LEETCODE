/*
Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.


Example 1:

Input: n = 16
Output: true

Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true


Constraints:

-231 <= n <= 231 - 1
*/




class Solution {
    public boolean isPowerOfFour(int n) {
        while(n >= 4) {
            if(n % 4 != 0) return false;
            n /= 4;
        }

        return n == 1;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 64;
        int n2 = 20;
        int n3 = 1;

        System.out.println(n1 + " is power of four? " + sol.isPowerOfFour(n1));
        System.out.println(n2 + " is power of four? " + sol.isPowerOfFour(n2));
        System.out.println(n3 + " is power of four? " + sol.isPowerOfFour(n3));
    }
}