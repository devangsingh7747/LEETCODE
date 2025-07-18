/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.


Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Example 3:

Input: coins = [1], amount = 0
Output: 0

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
*/




class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;

        int [] minCoinsDP = new int[amount + 1];

        for(int i = 1; i <= amount; i++) {
            minCoinsDP[i] = Integer.MAX_VALUE;

            for(int coin : coins) {
                if(coin <= i && minCoinsDP[i - coin] != Integer.MAX_VALUE) {
                    minCoinsDP[i] = Math.min(minCoinsDP[i], 1 + minCoinsDP[i - coin]);
                }
            }
        }

        if(minCoinsDP[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return minCoinsDP[amount];
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Min coins needed: " + sol.coinChange(coins1, amount1));  // Output: 3 (5+5+1)

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Min coins needed: " + sol.coinChange(coins2, amount2));  // Output: -1

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Min coins needed: " + sol.coinChange(coins3, amount3));  // Output: 0
    }
}