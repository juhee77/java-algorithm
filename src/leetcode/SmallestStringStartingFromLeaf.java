package leetcode;

import leetcode.EvenOddTree.TreeNode;

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
class SmallestStringStartingFromLeaf {
    public String smallestFromLeaf(TreeNode root) {
        return find(root, "");
    }

    private String find(TreeNode root, String now) {
        if (root == null)
            return now;
        String left = find(root.left, (char) ('a' + root.val) + now);
        String right = find(root.right, (char) ('a' + root.val) + now);

        if (root.left == null) return right;
        if (root.right == null) return left;
        return left.compareTo(right) <= 0 ? left : right;
    }
}