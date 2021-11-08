/*


Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 19


*/

class Solution {
    public int numTrees(int n) {
        return trees(1, n);
    }
    
    int trees(int lo, int hi) {
        if (lo >= hi) return 1;
        int total = 0;
        for (int i = lo; i <= hi; i++)
            total += trees(lo, i - 1) * trees(i + 1, hi);
        return total;
    }
}


class Solution {
  
    public int numTrees(int n) {
// For n == 0, empty tree is a valid BST.
        // For n == 1, valid BST can have only one node.
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // We only need to do half as dp[i] is symmetrical.
            // For example, when i = 5:
            // dp[i] = dp[0]*dp[4] + dp[1]*dp[3] + dp[2]*dp[2] + dp[3]*dp[1] + dp[4]*dp[0]
            // Here except dp[2]*dp[2] all others are appearing twice.
            for (int j = 0; j < i / 2; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
            dp[i] *= 2;

            // Only add i/2 * i/2 for odd numbers.
            if ((i & 1) == 1) {
                dp[i] += dp[i / 2] * dp[i / 2];
            }
        }

        return dp[n];
        
    }
}
