/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

Input: numRows = 1
Output: [[1]]

Constraints:

1 <= numRows <= 30
*/





import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        if(numRows == 1) return result;

        for(int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 0; j < i - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            row.add(1);
            result.add(row);
        }

        return result;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows for Pascal's Triangle: ");
        int numRows = sc.nextInt();

        Solution sol = new Solution();
        List<List<Integer>> triangle = sol.generate(numRows);

        System.out.println("Pascal's Triangle:");
        for (List<Integer> row : triangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
