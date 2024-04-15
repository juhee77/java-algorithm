package leetcode;

import java.util.Arrays;

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
class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int[] found = dfs(0, root);
        System.out.println(Arrays.toString(found));
        int sum = 0;
        for (int temp : found) {
            sum += temp;
        }
        return sum;
    }

    public int[] dfs(int hold, TreeNode node) {
        int[] left;
        int total = 0;
        if (node.left != null) {
            left = dfs(hold * 10 + node.val, node.left);
            total += left.length;
        } else left = null;


        int[] right;
        if (node.right != null) {
            right = dfs(hold * 10 + node.val, node.right);
            total += right.length;
        } else right = null;

        int[] returned = new int[total];

        if (left != null)
            System.arraycopy(left, 0, returned, 0, left.length);
        if (right != null) {
            if (left != null)
                System.arraycopy(right, 0, returned, left.length, right.length);
            else
                System.arraycopy(right, 0, returned, 0, right.length);
        }

        System.out.println(Arrays.toString(left) + "   " + Arrays.toString(right));
        System.out.println("returned " + Arrays.toString(returned));
        if (left == null && right == null) return new int[]{hold * 10 + node.val};
        return returned;

    }

    public int sumNumbers2(TreeNode root) {
        return dfs2(0, root);
    }

    private int dfs2(int currentSum, TreeNode node) {
        if (node == null) return 0;

        int newSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return newSum;
        }

        int leftSum = dfs2(newSum, node.left);
        int rightSum = dfs2(newSum, node.right);

        return leftSum + rightSum;
    }
}
