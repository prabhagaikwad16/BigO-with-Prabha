package h_BinaryTree;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.val = data;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.val = data;
        this.left = left;
        this.right = right;
    }
}
