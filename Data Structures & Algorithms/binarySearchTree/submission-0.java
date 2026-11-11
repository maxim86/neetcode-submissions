class TreeMap {
    private static class TreeNode {
        int key;
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private TreeNode root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        root = insert(root, key, val);
    }

    private TreeNode insert(TreeNode node, int key, int val) {
        if (node == null) {
            return new TreeNode(key, val);
        }
        if (key < node.key) {
            node.left = insert(node.left, key, val);
        } else if (key > node.key) {
            node.right = insert(node.right, key, val);
        } else {
            node.val = val;
        }
        return node;
    }

    public int get(int key) {
        TreeNode curr = root;
        while (curr != null) {
            if (key < curr.key) {
                curr = curr.left;
            } else if (key > curr.key) {
                curr = curr.right;
            } else {
                return curr.val;
            }
        }
        return -1;
    }

    public int getMin() {
        if (root == null) {
            return -1;
        }
        TreeNode curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.val;
    }

    public int getMax() {
        if (root == null) {
            return -1;
        }
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.val;
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    private TreeNode remove(TreeNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = remove(node.left, key);
        } else if (key > node.key) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            TreeNode minLargerNode = getMinNode(node.right);
            node.key = minLargerNode.key;
            node.val = minLargerNode.val;
            node.right = remove(node.right, minLargerNode.key);
        }
        return node;
    }

    private TreeNode getMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.key);
        inorder(node.right, result);
    }
}