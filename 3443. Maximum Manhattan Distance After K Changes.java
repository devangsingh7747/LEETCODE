/*
You are given a string s consisting of the characters 'N', 'S', 'E', and 'W', where s[i] indicates movements in an infinite grid:

'N' : Move north by 1 unit.
'S' : Move south by 1 unit.
'E' : Move east by 1 unit.
'W' : Move west by 1 unit.
Initially, you are at the origin (0, 0). You can change at most k characters to any of the four directions.

Find the maximum Manhattan distance from the origin that can be achieved at any time while performing the movements in order.

The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.

Example 1:

Input: s = "NWSE", k = 1

Output: 3

Explanation:

Change s[2] from 'S' to 'N'. The string s becomes "NWNE".

Movement	Position (x, y)	Manhattan Distance	Maximum
s[0] == 'N'	(0, 1)	0 + 1 = 1	1
s[1] == 'W'	(-1, 1)	1 + 1 = 2	2
s[2] == 'N'	(-1, 2)	1 + 2 = 3	3
s[3] == 'E'	(0, 2)	0 + 2 = 2	3
The maximum Manhattan distance from the origin that can be achieved is 3. Hence, 3 is the output.

Example 2:

Input: s = "NSWWEW", k = 3

Output: 6

Explanation:

Change s[1] from 'S' to 'N', and s[4] from 'E' to 'W'. The string s becomes "NNWWWW".

The maximum Manhattan distance from the origin that can be achieved is 6. Hence, 6 is the output.

Constraints:

1 <= s.length <= 105
0 <= k <= s.length
s consists of only 'N', 'S', 'E', and 'W'.
*/


// MANHATTAN MEANS = MAKE YOU POINT AS FAR AS POSSIBLE FROM THE ORIGIN(0, 0).



class Solution {
    public int maxDistance(String s, int k) {
        int ans = 0;

        for(char hor : new char[] {'E', 'W'}) {
            for(char ver : new char[] {'N', 'S'}) {
                int remainingK = k, netX = 0, netY = 0;

                for(char ch : s.toCharArray()) {
                    if(ch == hor && remainingK > 0) {
                        ch = (ch == 'E') ? 'W' : 'E';
                        remainingK--;
                    }

                    if(ch == ver && remainingK > 0) {
                        ch = (ch == 'N') ? 'S' : 'N';
                        remainingK--;
                    }

                    if(ch == 'E') netX++;
                    if(ch == 'W') netX--;
                    if(ch == 'N') netY++;
                    if(ch == 'S') netY--;

                    ans = Math.max(ans, Math.abs(netX) + Math.abs(netY));
                }
            }
        }

        return ans;
    }


    // Driver Code
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "ENWSENWS";
        int k = 2;

        int result = solution.maxDistance(s, k);
        System.out.println("Maximum distance: " + result);
    }
}