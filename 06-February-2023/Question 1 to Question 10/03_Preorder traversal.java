// RECURSIVE

class BinaryTree
{
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        // Code here
        ArrayList<Integer> list=new ArrayList<>();
        findpreorder(root,list);
        return list;
    }
    static void findpreorder(Node root,ArrayList<Integer> list){
        if(root!=null){
            list.add(root.data);
            findpreorder(root.left,list);
            findpreorder(root.right,list);
        }
    }

}

//ITERATIVE

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> q=new Stack<>();
        List<Integer> list=new LinkedList<>();

        if(root==null) return list;
        q.push(root);
        while(!q.isEmpty()){
            TreeNode temp=q.pop();
            list.add(temp.val);
            if(temp.right!=null) q.push(temp.right);

            if(temp.left!=null) q.push(temp.left);
        }
        return list;
    }
}
