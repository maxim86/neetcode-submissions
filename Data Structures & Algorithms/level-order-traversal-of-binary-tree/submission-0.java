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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) 
            return Collections.emptyList();
        
        var queue = new LinkedList<TreeNode>();
        var result = new LinkedList<List<Integer>>();

        queue.add(root);

        while (!queue.isEmpty()) {
            var levelSize = queue.size();
            var currentLevel = new ArrayList<Integer>();

            for (int i = 0; i < levelSize; i++) {
                var curr = queue.poll();
                currentLevel.add(curr.val);

                if (curr.left != null) queue.offer(curr.left);  
                if (curr.right != null) queue.offer(curr.right);
            }

            result.add(currentLevel);
        }

        return result;
    }
}
