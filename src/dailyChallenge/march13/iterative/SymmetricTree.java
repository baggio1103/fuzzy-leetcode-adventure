package dailyChallenge.march13.iterative;

import java.util.*;

public class SymmetricTree {

    public static void main(String[] args) {
        var solution = new Solution();

        var root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        var nodeTwo = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));

        var nodeThree = new TreeNode(3,
                new TreeNode(4, new TreeNode(5, new TreeNode(6), null), null),
                new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6))));

        var nodeFour = new TreeNode(3,
                new TreeNode(4, new TreeNode(5, new TreeNode(6, new TreeNode(7), null), null), null),
                new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6, null, new TreeNode(7)))));

        var nodeFive = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println(solution.isSymmetric(root));
        System.out.println("NodeTwo --=-=-=-=---=-=-=-=---=-=-=-=---=-=-=-=-");
        System.out.println(solution.isSymmetric(nodeTwo));
        System.out.println("--=-=-=-=---=-=-=-=---=-=-=-=---=-=-=-=-");
        System.out.println(solution.isSymmetric(nodeThree));
        System.out.println("--=-=-=-=---=-=-=-=---=-=-=-=---=-=-=-=-");
        System.out.println(solution.isSymmetric(nodeFour));
        System.out.println("--=-=-=-=---=-=-=-=---=-=-=-=---=-=-=-=-");
        System.out.println(solution.isSymmetric(nodeFive));
        System.out.println("--=-=-=-=---=-=-=-=---=-=-=-=---=-=-=-=-");
    }

}


class Solution {

    public List<Integer> stackLeftTraverse(TreeNode root) {
        var stack = new Stack<TreeNode>();
        var list = new ArrayList<Integer>();
        stack.push(root);
        list.add(root.val);
        while (!stack.isEmpty()) {
            var node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
                list.add(node.left.val);
            } else {
                list.add(null);
            }
            if (node.right != null) {
                stack.push(node.right);
                list.add(node.right.val);
            } else {
                list.add(null);
            }

        }
        return list;
    }

    public List<Integer> stackRightTraverse(TreeNode root) {
        var stack = new Stack<TreeNode>();
        var list = new ArrayList<Integer>();
        stack.push(root);
        list.add(root.val);
        while (!stack.isEmpty()) {
            var node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
                list.add(node.right.val);
            } else {
                list.add(null);
            }
            if (node.left != null) {
                stack.push(node.left);
                list.add(node.left.val);
            } else {
                list.add(null);
            }

        }
        return list;
    }


    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        var leftSubTreeNodes = stackLeftTraverse(root);
        var rightSubTreeNodes = stackRightTraverse(root);
        System.out.println(leftSubTreeNodes);
        System.out.println(rightSubTreeNodes);
        return leftSubTreeNodes.equals(rightSubTreeNodes);
    }

}

class TreeNode {
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
