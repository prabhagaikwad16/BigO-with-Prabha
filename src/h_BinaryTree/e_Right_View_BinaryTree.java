package h_BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class e_Right_View_BinaryTree {
    public static void main(String[] args) {
        e_Right_View_BinaryTree rightViewBinaryTree = new e_Right_View_BinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        List<Integer> result = rightViewBinaryTree.rightSideView(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }


    /*Right side view means if we traverse tree from right element first then whichever first element comes that should be considered into result on that particular level*/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        recursion(root,0,result);

        return result;
    }

    private void recursion(TreeNode root, int level, List<Integer> result){
        if(root == null){
            return;
        }

        //Check if the level is equal to the size of the result list
        //Whichever first element comes (eigther from right side or left side) on current level, consider that into result.
        if(level == result.size()){
            result.add(root.val);
        }

        //Traverse--> Preorder-->RL i.e. Root-->Right-->Left
        recursion(root.right,level+1,result);
        recursion(root.left,level+1,result);
    }
}
