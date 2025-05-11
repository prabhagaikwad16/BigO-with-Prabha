package h_BinaryTree;

import java.util.List;

public class c_PostOrder_Traversal {
    public static void main(String[] args) {
        c_PostOrder_Traversal postOrderTraversal = new c_PostOrder_Traversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> result = postOrderTraversal.postorderTraversal(root);
        System.out.println("Result = "+result);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new java.util.ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        postorder(root.left,result);
        postorder(root.right,result);
        result.add(root.val);
    }
}
