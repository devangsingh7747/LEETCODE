/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:

1 <= n <= 45
*/




class Solution {
    private int [] memo;

    public int climbStairs(int n) {
        memo = new int[n+1];
        return fib(n);
    }

    public int fib(int n) {
        if(n <= 1) {
            memo[n] = 1;
            return memo[n];
        }

        if(memo[n] != 0) return memo[n];

        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

    // Driver Code
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5; // Example input
        int ways = solution.climbStairs(n);
        System.out.println("Number of ways to climb " + n + " stairs: " + ways);
    }
}