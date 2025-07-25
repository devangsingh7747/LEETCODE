/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
*/





class Solution {
    public int jump(int[] nums) {
        int totalJumps = 0;
        int destination = nums.length - 1;
        int coverage = 0, lastJumpIdx = 0;

        if(nums.length == 1) return 0;

        for(int i = 0; i < nums.length; i++) {
            coverage = Math.max(coverage, i + nums[i]);

            if(i == lastJumpIdx) {
                lastJumpIdx = coverage;
                totalJumps++;

                if(coverage >= destination) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;

    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {2, 3, 1, 1, 4};     // Expected output: 2
        int[] nums2 = {2, 1};              // Expected output: 1
        int[] nums3 = {1, 1, 1, 1};        // Expected output: 3
        int[] nums4 = {0};                 // Expected output: 0

        System.out.println("Minimum jumps for nums1: " + sol.jump(nums1));
        System.out.println("Minimum jumps for nums2: " + sol.jump(nums2));
        System.out.println("Minimum jumps for nums3: " + sol.jump(nums3));
        System.out.println("Minimum jumps for nums4: " + sol.jump(nums4));
    }
}