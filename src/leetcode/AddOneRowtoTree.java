package leetcode;

import leetcode.EvenOddTree.TreeNode;

class AddOneRowtoTree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        dfs(root, 1, depth, val);
        return root;
    }

    private void dfs(TreeNode root, int currentDepth, int targetDepth, int val) {
        if (root == null) return;

        if (currentDepth == targetDepth - 1) {
            TreeNode leftNode = new TreeNode(val);
            leftNode.left = root.left;
            root.left = leftNode;

            TreeNode rightNode = new TreeNode(val);
            rightNode.right = root.right;
            root.right = rightNode;
        } else {
            dfs(root.left, currentDepth + 1, targetDepth, val);
            dfs(root.right, currentDepth + 1, targetDepth, val);
        }
    }
}
