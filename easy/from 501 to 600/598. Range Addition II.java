/*

You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.

Count and return the number of maximum integers in the matrix after performing all the operations.

 

Example 1:


Input: m = 3, n = 3, ops = [[2,2],[3,3]]
Output: 4
Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.
Example 2:

Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
Output: 4
Example 3:

Input: m = 3, n = 3, ops = []
Output: 9
 

Constraints:

1 <= m, n <= 4 * 104
0 <= ops.length <= 104
ops[i].length == 2
1 <= ai <= m
1 <= bi <= n

*/

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        /*
            Despite being an easy problem, the problem is quite tricky if you were to try to figure out a more clever way to solve it.
            The most straightforward way of doing it is following what the directions ask:
                - Increment each square from (0, 0) to (x, y) for each operation.
                - Iterate over the whole matrix to find the number that appears the most (we can assume that the numbers appear in a square due to the way we added it in the first bullet).
            This works, but this involves a lot of extra steps that are not necessary.
            The more clever way to solve it is to figure out what is the intersection of the bounds such that all rectangles formed by ops overlaps.
            We know that every formed rectangle starts at the top left (0, 0), so we just need to find the minimum of these coordinates.
            Once we do, we just find the area of that intersecting rectangle.
            
            Time: O(n) - the algorithm iterates over n given operations.
            Space: O(1) - algorithm does not user extra space.
        */
        
        // We just need to find the min dimensions and then multiply the coordinates
        int x = m, y = n;
        for (int[] op : ops) {
            x = Math.min(x, op[0]);
            y = Math.min(y, op[1]);
        }
        
        return x * y;
    }
}
