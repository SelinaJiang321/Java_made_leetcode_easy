/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100


*/

class Solution {
    public void flatten(TreeNode root) {
        // so hard to do it in iterative way
        // if (root == null) return;
        // while (root != null)
        // {
        //     if (root.left != null) {
        //         TreeNode currRight = root.right;
        //         root.right = root.left;
        //         root.left = null;
        //         TreeNode rightNode = root.right;
        //         while (rightNode != null && rightNode.right != null) {
        //             rightNode = rightNode.right;
        //         }
        //         rightNode.right = currRight;
        //     }
        //     root = root.right;
        // }    
        if (root == null) return;
        
        //traverse left node first then right node
        flatten(root.left);
        flatten(root.right);
        TreeNode currRight = root.right;
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            while (root.right != null) {
                root = root.right;
            }
            
            root.right = currRight;
        }
    }
}
