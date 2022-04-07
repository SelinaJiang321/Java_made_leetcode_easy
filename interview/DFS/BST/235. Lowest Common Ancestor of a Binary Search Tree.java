/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //相等，即为其中之一
        if (root == p || root == q) return root;
        
        //都小于 在左子树寻找
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left,p,q);
        
        //都大于 在右子树寻找
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right,p,q);
        
        return root;
        
    }
}
