package leetcode;

import java.util.ArrayList;
import java.util.List;

class BalanceABinarySearchTree_1382 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> all = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        findInOrder(root);
        return makeAns(0, all.size() - 1);
    }

    public TreeNode makeAns(int start, int end) {
        if (end < start)
            return null;
        int mid = (start + end) / 2;

        TreeNode temp = new TreeNode(all.get(mid));
        temp.left = makeAns(start, mid - 1);
        temp.right = makeAns(mid + 1, end);
        return temp;
    }

    public void findInOrder(TreeNode temp) {
        if (temp.left != null)
            findInOrder(temp.left);
        all.add(temp.val);
        if (temp.right != null)
            findInOrder(temp.right);
    }
}