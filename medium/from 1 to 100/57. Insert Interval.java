/*

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
Example 3:

Input: intervals = [], newInterval = [5,7]
Output: [[5,7]]
Example 4:

Input: intervals = [[1,5]], newInterval = [2,3]
Output: [[1,5]]
Example 5:

Input: intervals = [[1,5]], newInterval = [2,7]
Output: [[1,7]]
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= intervals[i][0] <= intervals[i][1] <= 105
intervals is sorted by intervals[i][0] in ascending order.
newInterval.length == 2
0 <= newInterval[0] <= newInterval[1] <= 105


*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int[] toAdd = newInterval;
        for (int[] interval: intervals){
            //if the current is larger than the Max in toAdd:
            if (toAdd[1] < interval[0]) {
                ans.add(toAdd);
                toAdd = interval;
            }
            //if the current is smaller than the min in toAdd;
            else if (toAdd[0] > interval[1]) {
                ans.add(interval);
            } 
            // there are overlaps
            else {
                toAdd = new int[] {Math.min(interval[0],toAdd[0]),Math.max(interval[1],toAdd[1])};
            }
        }
        ans.add(toAdd);
        return ans.toArray(new int[ans.size()][2]);
    }
}
