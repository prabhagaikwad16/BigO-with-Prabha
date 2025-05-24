package h_BinaryTree;

import java.util.List;

public class b_PreOrder_Traversal_Recursive {
    public static void main(String[] args) {

        b_PreOrder_Traversal_Recursive preOrderTraversal = new b_PreOrder_Traversal_Recursive();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> result = preOrderTraversal.preorderTraversal(root);
        System.out.println("Result = "+result);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new java.util.ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        result.add(root.val);
        preorder(root.left,result);
        preorder(root.right,result);
    }
}
