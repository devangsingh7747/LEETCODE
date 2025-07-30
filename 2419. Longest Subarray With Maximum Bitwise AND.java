/*
You are given an integer array nums of size n.

Consider a non-empty subarray from nums that has the maximum possible bitwise AND.

In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
Return the length of the longest such subarray.

The bitwise AND of an array is the bitwise AND of all the numbers in it.

A subarray is a contiguous sequence of elements within an array.


Example 1:

Input: nums = [1,2,3,3,2,2]
Output: 2
Explanation:
The maximum possible bitwise AND of a subarray is 3.
The longest subarray with that value is [3,3], so we return 2.

Example 2:

Input: nums = [1,2,3,4]
Output: 1
Explanation:
The maximum possible bitwise AND of a subarray is 4.
The longest subarray with that value is [4], so we return 1.

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 106
*/





import java.util.*;

class Solution {
    public int longestSubarray(int[] nums) {
        int largest = 0;
        for(int num : nums) {
            largest = Math.max(num, largest);
        }

        int count = 0, maxAns = 1;
        for(int num : nums) {
            if(num == largest) {
                count++;
                maxAns = Math.max(count, maxAns);
            } else {
                count = 0;
            }
        }

        return maxAns;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 3, 3, 2, 3, 3, 3, 2};
        int result = sol.longestSubarray(nums);

        System.out.println("Longest subarray length with maximum element: " + result);
    }
}
