package leetcode;

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
class StepByStepDirectionsFromBTree_2096 {

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

    private static boolean flag = false;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        flag = false;
        findRoot(root, startValue, start);
        flag = false;
        findRoot(root, destValue, end);

        int index = 0;
        while (index < Math.min(start.length(), end.length())) {
            if (start.charAt(index) == end.charAt(index)) index++;
            else break;
        }

        return "U".repeat(start.length() - index) + end.substring(index);
    }

    private boolean findRoot(TreeNode root, int value, StringBuilder path) {
        if (root == null) return false;
        if (root.val == value) {
            flag = true;
            return true;
        }

        path.append("L");
        if (findRoot(root.left, value, path)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append("R");
        if (findRoot(root.right, value, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }
}