package h_BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class h_OnOrder_Traversal_Iterative {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }

        return result;
    }
}
