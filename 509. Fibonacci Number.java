/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

Constraints:

0 <= n <= 30
 */




    

class Solution {
    public int fib(int n) {

        /* Method 1: Recursive (Not recommended for large n)
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
        */

        // Method 2: Iterative - Optimized O(n) time, O(1) space
        if (n <= 1) return n;

        int a = 0, b = 1; // base cases: fib(0) = 0, fib(1) = 1

        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        System.out.println("fib(0): " + sol.fib(0));   // Expected: 0
        System.out.println("fib(1): " + sol.fib(1));   // Expected: 1
        System.out.println("fib(2): " + sol.fib(2));   // Expected: 1
        System.out.println("fib(5): " + sol.fib(5));   // Expected: 5
        System.out.println("fib(10): " + sol.fib(10)); // Expected: 55
    }
}
