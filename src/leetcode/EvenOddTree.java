package leetcode;

public class EvenOddTree {
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


    public TreeNode createBinaryTreeFromArray(Integer[] array) {
        if (array == null || array.length == 0)
            return null;

        TreeNode[] nodes = new TreeNode[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                nodes[i] = new TreeNode(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if (nodes[i] != null) {
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;
                if (leftIndex < array.length)
                    nodes[i].left = nodes[leftIndex];
                if (rightIndex < array.length)
                    nodes[i].right = nodes[rightIndex];
            }
        }

        return nodes[0];
    }

    private static int[] hold;

    public boolean isEvenOddTree(TreeNode root) {
        hold = new int[100001];
        return check(root, 0);
    }

    public boolean check(TreeNode temp, int level) {
        /// System.out.println(Arrays.toString(hold));
        if (temp == null)
            return true;

        //even
        if (level % 2 == 0) {
            // increasing
            if (hold[level] < temp.val && temp.val % 2 == 1) {
                hold[level] = temp.val;
                return check(temp.left, level + 1) && check(temp.right, level + 1);
            }
            return false;

        } else {
            // decreasing
            if (hold[level] == 0)
                hold[level] = 1000001;// setting max nums
            if (hold[level] > temp.val && temp.val % 2 == 0) {
                hold[level] = temp.val;
                return check(temp.left, level + 1) && check(temp.right, level + 1);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        EvenOddTree evenOddTree = new EvenOddTree();
        System.out.println(evenOddTree.isEvenOddTree(evenOddTree.createBinaryTreeFromArray(new Integer[]{1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2})));
        System.out.println(evenOddTree.isEvenOddTree(evenOddTree.createBinaryTreeFromArray(new Integer[]{5, 4, 2, 3, 3, 7})));
        System.out.println(evenOddTree.isEvenOddTree(evenOddTree.createBinaryTreeFromArray(new Integer[]{5, 9, 1, 3, 5, 7})));
    }
}
