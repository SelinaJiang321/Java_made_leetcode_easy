/*

Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

 

Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
Example 3:

Input: root = [2,1,3], k = 4
Output: true
Example 4:

Input: root = [2,1,3], k = 1
Output: false
Example 5:

Input: root = [2,1,3], k = 3
Output: true
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        HashSet<Integer> numbers = new HashSet<>();
        return check(root,k,numbers);
        
        
    }
    public boolean check(TreeNode root, int target, HashSet<Integer> numbers) {
        if (root == null) return false;
        if (numbers.contains(target - root.val)) {
                return true;
        }
        numbers.add(root.val);
        if (root.left == null) 
        {
            return check(root.right, target,numbers); 
            
        }
        if (root.right == null) 
        {
            return check(root.left, target,numbers);             
        }

        //root.right != null && root.left != null
        else {
            return check(root.right, target,numbers)  || 
                check(root.left, target,numbers); 
        }
        
    }
}
