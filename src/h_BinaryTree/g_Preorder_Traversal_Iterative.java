package h_BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class g_Preorder_Traversal_Iterative {
    public static void main(String[] args) {

        g_Preorder_Traversal_Iterative preOrderTraversal = new g_Preorder_Traversal_Iterative();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> result = preOrderTraversal.preorderTraversal(root);
        System.out.println("Result = "+result);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            //As stack is List In First Out, add right first before left so then next time when we pop the left will be on top
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }

        return result;
    }
}
