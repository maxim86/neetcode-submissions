
class Solution {
    int preIdx = 0;
    Map<Integer, Integer> idxByVal = new HashMap<>(); // for inorder array

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            idxByVal.put(inorder[i], i);
        }
       
        return build(preorder, 0, inorder.length - 1); 
    }

    TreeNode build(int[] preorder, int start, int end) {
        if (start > end) return null;

        var rootVal = preorder[preIdx];
        var node = new TreeNode(rootVal);
        int rootIdx = idxByVal.get(rootVal);
        
        preIdx++;

        node.left = build(preorder, start, rootIdx - 1);
        node.right = build(preorder, rootIdx + 1, end);

        return node;
    }
}
