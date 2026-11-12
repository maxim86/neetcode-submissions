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
    Map<Integer, Integer> iByV = new HashMap<>();
    Integer preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            iByV.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1); 
    }

    TreeNode build(int[] preorder, int startIn, int endIn) {
        if (startIn > endIn) return null;

        var currVal = preorder[preIdx];
        var currIn = iByV.get(currVal);

        preIdx++;

        var left = build(preorder, startIn, currIn - 1);
        var right = build(preorder, currIn + 1, endIn);

        return new TreeNode(currVal, left, right);
    }
}
