package h_BinaryTree;

public class d_CalculateHeight_Tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.right = new TreeNode(6);

        d_CalculateHeight_Tree calculateHeightTree = new d_CalculateHeight_Tree();
        int height = calculateHeightTree.maxDepth(root);
        System.out.println(height);
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l =  maxDepth(root.left);
        int r = maxDepth(root.right);

        //every time 1 gets added to the height among the max height.
        return 1+Math.max(l,r);
    }

}
