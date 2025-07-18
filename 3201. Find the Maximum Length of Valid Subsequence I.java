/*
You are given an integer array nums.
A subsequence sub of nums with length x is called valid if it satisfies:

(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
Return the length of the longest valid subsequence of nums.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.


Example 1:

Input: nums = [1,2,3,4]

Output: 4

Explanation:

The longest valid subsequence is [1, 2, 3, 4].


Example 2:

Input: nums = [1,2,1,1,2,1,2]

Output: 6

Explanation:

The longest valid subsequence is [1, 2, 1, 2, 1, 2].


Example 3:

Input: nums = [1,3]

Output: 2

Explanation:

The longest valid subsequence is [1, 3].


Constraints:

2 <= nums.length <= 2 * 105
1 <= nums[i] <= 107
*/






class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;

        int oddCounter = (nums[0] % 2 == 1) ? 1 : 0;
        int evenCounter = (nums[0] % 2 == 0) ? 1 : 0;
        int alternateCounter = 1;
        boolean expec_Even = (nums[0] % 2 == 1) ? true : false;

        for(int i = 1; i < n; ++i) {
            if((expec_Even == true && nums[i] % 2 == 0) || (expec_Even == false && nums[i] % 2 == 1)) {
                alternateCounter++;
                expec_Even = !expec_Even;
            }

            if(nums[i] % 2 == 1) {
                oddCounter++;
            }
            if(nums[i] % 2 == 0) {
                evenCounter++;
            }
        }

        return Math.max(Math.max(oddCounter, evenCounter), alternateCounter);
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums1 = {1, 2, 3, 4, 5}; // Example input
        int result1 = sol.maximumLength(nums1);
        System.out.println("Maximum Length: " + result1);

        int[] nums2 = {2, 4, 6, 8}; // All even
        int result2 = sol.maximumLength(nums2);
        System.out.println("Maximum Length: " + result2);

        int[] nums3 = {1, 3, 5, 2, 4}; // Mixed
        int result3 = sol.maximumLength(nums3);
        System.out.println("Maximum Length: " + result3);
    }
}