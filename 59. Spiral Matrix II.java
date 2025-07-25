/*
Medium
Topics
premium lock icon
Companies
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:

Input: n = 1
Output: [[1]]

Constraints:

1 <= n <= 20
*/




import java.util.*;

class Solution {
    public int[][] generateMatrix(int n) {
        int matrix [][] = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, down = n - 1;
        int ct = 1;

        while(ct <= n * n) {
            //left to right
            for(int i = left; i <= right && ct <= n * n; i++) {
                matrix[top][i] = ct++;
            }
            top++;

            //top to down
            for(int j = top; j <= down && ct <= n * n; j++) {
                matrix[j][right] = ct++;
            }
            right--;

            //right to left
            for(int i = right; i >= left && ct <= n * n; i--) {
                matrix[down][i] = ct++;
            }
            down--;

            //down to top
            for(int j = down; j >= top && ct <= n * n; j--) {
                matrix[j][left] = ct++;
            }
            left++;
        }

        return matrix;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4; // you can change n for different size matrices
        int[][] result = sol.generateMatrix(n);

        System.out.println("Spiral Matrix:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}