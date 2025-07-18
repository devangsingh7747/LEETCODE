/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.


Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
*/


class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        return n;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        int index = solution.searchInsert(nums, target);
        System.out.println("The target should be inserted at index: " + index);
    }
}