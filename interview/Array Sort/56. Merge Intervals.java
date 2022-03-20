class Solution {
    public int[][] merge(int[][] intervals) {
        //we need to sort them according to intervals[i][0]
        if (intervals.length <=1) return intervals;
        Arrays.sort(intervals,(i1,i2) -> Integer.compare(i1[0],i2[0]));
        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);
        for (int[] interval: intervals) {
            //overlapping
            if (newInterval[1] >= interval[0]) {
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }
            else {
                newInterval = interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][] );
        
    }
}
