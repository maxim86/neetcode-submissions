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
    public List<Integer> rightSideView(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        var result = new ArrayList<Integer>();

        if (root == null) return List.of();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                var curr = queue.poll();
                
                if (curr.left != null) 
                    queue.offer(curr.left);
                
                if (curr.right != null) 
                    queue.offer(curr.right);
                
                if (i == size - 1) {
                    result.add(curr.val);
                }
            }
        }

        return result;
    }
}
