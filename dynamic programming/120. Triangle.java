/*

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        
        // get the bottom of the row
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[] M = new int[n];
        
        for (int i = 0; i < n; i++) {
            M[i] = triangle.get(m-1).get(i);
        }
        
         // induction rule
        // M[i] = min(M[i], M[i + 1]) + curVal
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            for (int j = 0; j < curr.size(); j++) {
                M[j] = Math.min(M[j],M[j+1]) + curr.get(j);
            }
        }
        return M[0];
        
    }
}

//bottom-up principle -> get the number of the minimum sum at the bottom and update until get to M[0]
