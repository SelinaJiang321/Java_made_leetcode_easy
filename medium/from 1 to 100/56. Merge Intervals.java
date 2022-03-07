/*

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104



*/

class Solution {
    public int[][] merge(int[][] intervals) {
        //edge cases first
        if (intervals.length <= 1) return intervals;
        
        //sorting the array with the starting point
        Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1[0],i2[0]));
        List<int[]> res = new ArrayList<>();
        //keep track of the new interval
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for (int[] interval: intervals) {
            if (newInterval[1] >= interval[0]) {
                newInterval[1] = Math.max(newInterval[1],interval[1]);
                //looking at the next interval
            }else {
                newInterval = interval;
                res.add(newInterval);
            }
        }
        //transform an array list to a 2d array
        return res.toArray(new int[res.size()][2]);
        
    }
}
