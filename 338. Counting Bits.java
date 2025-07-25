/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.


Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

Constraints:

0 <= n <= 105

Follow up:

It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
*/





import java.util.*;

class Solution {
    public int[] countBits(int n) {
        int [] result = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            result[i] = result[i / 2] + (i % 2);
        }

        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5; // You can change this value to test other cases
        int[] result = sol.countBits(n);

        System.out.println("Count of set bits from 0 to " + n + ":");
        System.out.println(Arrays.toString(result));
    }
}