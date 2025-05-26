/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.


Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
 */







class Solution {
    public boolean canJump(int[] nums) {
        int max_value = 0;

        for(int i=0; i<nums.length; i++) {
            if(i > max_value) {
                return false;
            }

            max_value = Math.max(max_value, i + nums[i]);
        }

        return true;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        System.out.println("Can jump (nums1): " + solution.canJump(nums1)); // true
        System.out.println("Can jump (nums2): " + solution.canJump(nums2)); // false
    }
}