/*

You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.

 

Example 1:

Input: pairs = [[1,2],[2,3],[3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4].
Example 2:

Input: pairs = [[1,2],[7,8],[4,5]]
Output: 3
Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 

Constraints:

n == pairs.length
1 <= n <= 1000
-1000 <= lefti < righti < 1000


Sort the pairs by first coordinate, 
and let dp[i] be the length of the longest chain ending at pairs[i]. 
When i < j and pairs[i][1] < pairs[j][0], we can extend the chain, 
and so we have the candidate answer dp[j] = max(dp[j], dp[i] + 1).



*/

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)->a[0] - b[0]);
        int len = pairs.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        
        for (int j = 1; j < len; ++j) {
            for (int i = 0; i < j; ++i) {
                if (pairs[i][1] < pairs[j][0]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        
        int ans = 0;
        for (int x: dp) {
            if (x > ans) {
                ans = x;
            }
        }
        
        return ans;
        
    }
}
