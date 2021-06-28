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
