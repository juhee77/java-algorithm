package leetcode;

import java.util.HashMap;

class CreateBinaryTreeFromDescriptions_2196 {
    /**
     * 와 진짜 기깔나게 풀은것 같아..
     * 는 근데 사실 child인 경우만 모두 헤시셋으로 넣어서
     * set에서 child인경우 제거하고 남은게 root 여서 그거 반환하면 됨
     */

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

    public static class Node extends TreeNode {
        int parents = -1;

        public Node() {

        }

        public Node(int val) {
            super(val);
        }

        public Node(int val, TreeNode left, TreeNode right, int parents) {
            super(val, left, right);
            this.parents = parents;
        }
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, Node> map = new HashMap<>();
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int dir = description[2];
            if (!map.containsKey(parent)) {
                map.put(parent, new Node());
            }

            if (!map.containsKey(child)) map.put(child, new Node());

            Node childNode = map.get(child);
            childNode.parents = parent;

            if (dir == 1) map.get(parent).left = childNode;
            if (dir == 0) map.get(parent).right = childNode;
        }

        Node root = null;
        for (Integer key : map.keySet()) {
            if (map.get(key).parents == -1) {
                root = map.get(key);
            }
        }

        return root;
    }
}