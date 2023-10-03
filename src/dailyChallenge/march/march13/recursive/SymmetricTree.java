package dailyChallenge.march.march13.recursive;

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
        solution.isSymmetric(nodeFive);
        System.out.println("--=-=-=-=---=-=-=-=---=-=-=-=---=-=-=-=-");
        System.out.println(solution.isSymmetric(root));
        System.out.println("NodeTwo --=-=-=-=---=-=-=-=---=-=-=-=---=-=-=-=-");
        System.out.println(solution.isSymmetric(nodeTwo));
        System.out.println("--=-=-=-=---=-=-=-=---=-=-=-=---=-=-=-=-");
        System.out.println(solution.isSymmetric(nodeThree));
        System.out.println("--=-=-=-=---=-=-=-=---=-=-=-=---=-=-=-=-");
        System.out.println(solution.isSymmetric(nodeFour));
        System.out.println("--=-=-=-=---=-=-=-=---=-=-=-=---=-=-=-=-");
    }

}


class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        var leftSubTreeNodes = new ArrayList<Integer>();
        var rightSubTreeNodes = new ArrayList<Integer>();
        leftOrder(root.left, leftSubTreeNodes);
        rightOrder(root.right, rightSubTreeNodes);
        return leftSubTreeNodes.equals(rightSubTreeNodes);
    }

    public void leftOrder(TreeNode root, List<Integer> nodes) {
        nodes.add(root != null ? root.val : null);
        if (root == null) {
            return;
        }
        leftOrder(root.left, nodes);
        leftOrder(root.right, nodes);
    }

    public void rightOrder(TreeNode root, List<Integer> nodes) {
        nodes.add(root != null ? root.val : null);
        if (root == null) {
            return;
        }
        rightOrder(root.right, nodes);
        rightOrder(root.left, nodes);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
