/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.

Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].

Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].

Constraints:

1 <= fruits.length <= 105
0 <= fruits[i] < fruits.length
*/




import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxFruits = 0;

        for(right = 0; right < fruits.length; right++) {
            int currentCount = basket.getOrDefault(fruits[right], 0);
            basket.put(fruits[right], currentCount + 1);

            while(basket.size() > 2) {
                int fruitCount = basket.get(fruits[left]);

                if(fruitCount == 1) {
                    basket.remove(fruits[left]);
                } else {
                    basket.put(fruits[left], fruitCount - 1);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] fruits1 = {1,2,1};
        int[] fruits2 = {0,1,2,2};
        int[] fruits3 = {1,2,3,2,2};
        int[] fruits4 = {3,3,3,1,2,1,1,2,3,3,4};

        System.out.println("Case 1: " + sol.totalFruit(fruits1));  // Output: 3
        System.out.println("Case 2: " + sol.totalFruit(fruits2));  // Output: 3
        System.out.println("Case 3: " + sol.totalFruit(fruits3));  // Output: 4
        System.out.println("Case 4: " + sol.totalFruit(fruits4));  // Output: 5
    }
}