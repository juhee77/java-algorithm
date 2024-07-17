package leetcode;

import java.util.*;

/**
 * Definition for a binary tree node.
 */

class DeleteNodesAndReturnForest {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean visited;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            visited = false;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            visited = false;
        }
    }

    HashMap<Integer, TreeNode> map = new HashMap<>();
    HashSet<Integer> removed = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        removed.clear();
        map.clear();

        for (int delete : to_delete) {
            removed.add(delete);
        }

        addAllNode(root);
        List<Integer> allNode = new ArrayList<>(map.keySet().stream().toList());
        List<TreeNode> ans = new ArrayList<>();
        Collections.sort(allNode);

        for (Integer key : allNode) {
            TreeNode nowNode = map.get(key);
            if (!nowNode.visited) {
                if (finded(nowNode))
                    ans.add(nowNode);
            }
        }
        return ans;
    }

    private boolean finded(TreeNode node) {
        if (node != null) {
            if (node.visited) return false;
            node.visited = true;
            finded(node.left);
            finded(node.right);
        }
        return true;
    }

    private boolean addAllNode(TreeNode root) {
        if (root == null)
            return false;

        if (addAllNode(root.left)) {
            root.left = null;

        }

        if (addAllNode(root.right)) {
            root.right = null;

        }

        if (removed.contains(root.val)) {
            root.left = null;
            root.right = null;
            return true;
        } else {
            map.put(root.val, root);
            return false;
        }
    }
}