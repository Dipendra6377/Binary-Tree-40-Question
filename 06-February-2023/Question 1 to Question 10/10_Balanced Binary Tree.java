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
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)!=-1;
    }
    public int maxDepth(TreeNode root) {
    
        if(root==null){
            return 0;
        }
        int max1= maxDepth(root.left);
        if(max1==-1) return -1;
        int max2 = maxDepth(root.right);
        if(max2==-1) return -1;

        if(Math.abs(max1-max2)>1) return -1;
        return 1 + Math.max(max1,max2);
    }
}
