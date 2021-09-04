/*
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.


*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates == null || coordinates[0].length == 0) return false;
       
        int[] p = coordinates[0];
        int[] q = coordinates[1];
        if (coordinates.length == 2){
            return true;
        }
        for(int i = 2; i < coordinates.length; i++) {
            int[] curr = coordinates[i];
            
            if((curr[0] - p[0]) * (q[1] - p[1]) != (curr[1] - p[1]) * (q[0] - p[0])) return false;
        }
        
        return true;
        
    }
}
