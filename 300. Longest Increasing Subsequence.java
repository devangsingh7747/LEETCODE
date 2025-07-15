/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.


Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
*/




class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] T = new int[nums.length];

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(T[j] + 1 > T[i]) {
                        T[i] = T[j] + 1;
                    }
                }
            }
        }

        int maxIndex = 0;
        for(int i = 0; i < T.length; i++) {
            if(T[i] > T[maxIndex]) {
                maxIndex = i;
            }
        }

        return T[maxIndex] + 1;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Sample input array
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        // Call the method and print result
        int lisLength = sol.lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + lisLength);
    }
}