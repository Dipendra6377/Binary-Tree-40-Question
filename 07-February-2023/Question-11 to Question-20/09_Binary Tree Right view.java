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
    public List<Integer> rightSideView(TreeNode root) {
        int level= 0;
        List<Integer> list=new LinkedList<>();

        traverse(root,list,level);
        return list;
    }

    public void traverse(TreeNode root,List<Integer> list,int lvl){
        if(root==null) return;

        if(lvl==list.size()){
            list.add(root.val);
        }

        traverse(root.right,list,lvl+1);
        traverse(root.left,list,lvl+1);
    }
}
