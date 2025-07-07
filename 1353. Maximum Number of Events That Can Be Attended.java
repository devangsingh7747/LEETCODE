/*
You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

Return the maximum number of events you can attend.


Example 1:


Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
Example 2:

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4


Constraints:

1 <= events.length <= 105
events[i].length == 2
1 <= startDayi <= endDayi <= 105
*/




import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;
        int pos = 0;
        int time = 1;
        int attended = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while(pos < n || !minHeap.isEmpty()) {
            if(minHeap.isEmpty()) {
                time = Math.max(time, events[pos][0]);
            }

            while(pos < n && events[pos][0] == time) {
                minHeap.offer(events[pos][1]);
                pos++;
            }

            while(!minHeap.isEmpty() && minHeap.peek() < time) {
                minHeap.poll();
            }

            if(!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }
            time++;
        }
        return attended;
    }

    // Driver Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] events1 = {{1,2}, {2,3}, {3,4}};
        int[][] events2 = {{1,2}, {2,3}, {3,4}, {1,2}};
        int[][] events3 = {{1,4}, {4,4}, {2,2}, {3,4}, {1,1}};

        System.out.println(sol.maxEvents(events1)); // Output: 3
        System.out.println(sol.maxEvents(events2)); // Output: 4
        System.out.println(sol.maxEvents(events3)); // Output: 4
    }
}