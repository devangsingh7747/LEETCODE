/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.


Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/



import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> current, List<List<Integer>> result) {
        if(i == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[i]);
        backtrack(nums, i+1, current, result);

        current.remove(current.size() - 1);

        backtrack(nums, i+1, current, result);
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};

        List<List<Integer>> result = sol.subsets(nums);

        System.out.println("All subsets:");
        for(List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}