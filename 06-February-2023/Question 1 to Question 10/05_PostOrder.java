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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        findpreorder(root,list);
        return list;
    }
    static void findpreorder(TreeNode root,List<Integer> list){
        if(root!=null){
            findpreorder(root.left,list);
            findpreorder(root.right,list);
            list.add(root.val);
        }
    }
}
