package leetcode;

import static leetcode.EvenOddTree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BinarySearchTreeToGreaterSumTree_1038 {
    int lastNode = 0;

    public TreeNode bstToGst(TreeNode root) {
        return getNode(root);
    }

    public TreeNode getNode(TreeNode node) {
        TreeNode ans = new TreeNode();

        if (node.right != null) {
            ans.right = getNode(node.right);
            lastNode = Math.max(ans.right.val, lastNode);
        }

        ans.val = node.val + lastNode;
        lastNode = ans.val;

        if (node.left != null) {
            ans.left = getNode(node.left);
            lastNode = Math.max(lastNode, ans.left.val);
        }

        return ans;
    }
}