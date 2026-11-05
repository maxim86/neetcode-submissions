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
class Dummy { 
    boolean val;
    Dummy(boolean val) {
        this.val = val;
    }
}
class Solution {
    
    public boolean isBalanced(TreeNode root) {
        var balanced = new Dummy(true);

        getHeight(root, balanced);
        
        return balanced.val;
    }

    int getHeight(TreeNode node, Dummy b) {
        if (node == null) return -1; 
        var leftH = getHeight(node.left, b);
        var rightH = getHeight(node.right, b);

        if (Math.abs(leftH - rightH) > 1) b.val = false; 

        return Math.max(leftH, rightH) + 1; 
    }
}
