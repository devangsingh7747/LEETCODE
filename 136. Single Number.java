/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.


Example 1:

Input: nums = [2,2,1]

Output: 1

Example 2:

Input: nums = [4,1,2,1,2]

Output: 4

Example 3:

Input: nums = [1]

Output: 1


Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.
*/



class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for(int num : nums) {
            result ^= num;
        }

        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {2, 2, 1};
        System.out.println("Single Number in [2, 2, 1]: " + sol.singleNumber(nums1));  // Output: 1

        // Example 2
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Single Number in [4, 1, 2, 1, 2]: " + sol.singleNumber(nums2));  // Output: 4

        // Example 3
        int[] nums3 = {1};
        System.out.println("Single Number in [1]: " + sol.singleNumber(nums3));  // Output: 1
    }
}