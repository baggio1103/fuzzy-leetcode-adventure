package contest320;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NodesOfBinaryTree {

    public static void main(String[] args) {
        var test = new NodesOfBinaryTree();
        var queries = List.of(2, 5, 16);
        var nodeValues = List.of(1, 2, 4, 6, 9, 13, 14, 15);
        System.out.println(test.findIndexAndKey(nodeValues, 5));
        System.out.println(test.findIndexAndKey(nodeValues, -1));
        System.out.println(test.findIndexAndKey(nodeValues, 16));
        var result = new ArrayList<List<Integer>>();
        System.out.println(result);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        var nodeValues = new ArrayList<Integer>();
        traverse(root, nodeValues);
        var result = new ArrayList<List<Integer>>();
        for (Integer query : queries) {
            var map = findIndexAndKey(nodeValues, query);
            map.forEach((min, max) -> result.add(List.of(min, max)));
        }
        return result;
    }

    public Map<Integer, Integer> findIndexAndKey(List<Integer> nodeValues, int value) {
        int low = 0;
        int high = nodeValues.size() - 1;
        while (low <= high) {
            var middle = (low + high) / 2;
            if (nodeValues.get(middle) == value) {
                return Map.of(value, value);
            } else if (nodeValues.get(middle) > value) {
                high = middle - 1;
            } else if (nodeValues.get(middle) < value) {
                low = middle + 1;
            }
        }
        if (high < 0) {
            return Map.of(-1, nodeValues.get(0));
        }
        if (low >= nodeValues.size()) {
            return Map.of(nodeValues.get(nodeValues.size()-1), -1);
        }
        return Map.of(nodeValues.get(high), nodeValues.get(low));
    }

    public void traverse(TreeNode root, List<Integer> nodeValues) {
        if (root == null) {
            return;
        }
        traverse(root.left, nodeValues);
        nodeValues.add(root.val);
        traverse(root.right, nodeValues);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}