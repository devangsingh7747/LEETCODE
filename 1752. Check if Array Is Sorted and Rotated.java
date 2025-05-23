/*
Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.


Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
 */




class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i=1; i<n; i++) {
            if(nums[i-1] > nums[i]) {
                count++;
            }
        }

        if(nums[n-1] > nums[0]) {
            count++;
        }

        return count <= 1;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Is rotated sorted: " + sol.check(nums1)); // Output: true

        // Test case 2
        int[] nums2 = {2, 1, 3, 4};
        System.out.println("Is rotated sorted: " + sol.check(nums2)); // Output: true

        // Test case 3
        int[] nums3 = {1, 2, 3};
        System.out.println("Is rotated sorted: " + sol.check(nums3)); // Output: false
    }
}