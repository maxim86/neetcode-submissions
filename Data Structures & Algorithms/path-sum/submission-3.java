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
    int currentSum; // current target sum
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        currentSum = targetSum;
        return backtrack(root);
    }

    public boolean backtrack(TreeNode node) {
        if (node == null) return false;
        if (node.left == null 
            && node.right == null 
            && currentSum == node.val) return true; 

        if (node.left != null) {
            currentSum -= node.val;
            if (backtrack(node.left)) 
                return true;
           
            currentSum += node.val;
        }

        if (node.right != null) {
            currentSum -= node.val;
            if (backtrack(node.right)) {
                return true;
            }
            currentSum += node.val;
        }

        return false;
    }
}