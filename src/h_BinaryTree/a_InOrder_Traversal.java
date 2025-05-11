package h_BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class a_InOrder_Traversal {


    public static void main(String[] args) {
            a_InOrder_Traversal inOrderTraversal = new a_InOrder_Traversal();
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            List<Integer> inordered = inOrderTraversal.inorderTraversal(root);
            System.out.println("Result = "+inordered);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
}
