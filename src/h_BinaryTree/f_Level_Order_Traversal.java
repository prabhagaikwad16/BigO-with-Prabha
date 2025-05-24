package h_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class f_Level_Order_Traversal {
    public static void main(String[] args) {

        f_Level_Order_Traversal levelOrderTraversal = new f_Level_Order_Traversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<List<Integer>> result = levelOrderTraversal.levelOrder(root);
        System.out.println("Level Order Traversal:");
        for (List<Integer> level : result) {
            for (int i = 0; i < level.size(); i++) {
                System.out.print(level.get(i) + " ");
            }
            System.out.println();
        }
    }

    /*Make use of 2 data structures
    * Queue to add nodes at each level.
    * List<List<Integer>> to hold list of each level list.*/

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //Add root node to Queue
        queue.offer(root);

        //While queue is not empty, process each level
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            //Get the size of the queue at current level
            int size = queue.size();
            //Process all nodes at current level
            for(int i=0; i<size; i++){
                //Poll the node from queue
                TreeNode node = queue.poll();
                //Add left and right children to queue if they are not null
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                //Add the value of the current node to the list
                list.add(node.val);
            }
            //Add the list of current level to the result
            result.add(list);
        }
        return result;
    }
}
