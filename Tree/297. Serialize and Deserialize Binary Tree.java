/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "{}";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        sb.append("{");
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head == null) sb.append("#");
            else {
                sb.append(head.val);
                queue.offer(head.left);
                queue.offer(head.right);
            }
            
            if (!queue.isEmpty()) sb.append(",");
        }
        sb.append("}");
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("{}")) return null;
        String[] value = data.substring(1,data.length() - 1).split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(value[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean checkLeft = true;
        
        for (int i =1; i < value.length; i++) {
            if (!value[i].equals("#")) {
                TreeNode child = new TreeNode(Integer.parseInt(value[i]));
                if (checkLeft) {
                    queue.peek().left = child;
                } else {
                    queue.peek().right = child;
                }
                queue.offer(child);
            }
            if(!checkLeft) queue.poll();
            checkLeft = !checkLeft;
        }
        
        
        
    
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
