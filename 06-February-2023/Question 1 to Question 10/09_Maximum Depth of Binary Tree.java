class Solution {
    public int maxDepth(TreeNode root) {
    
        if(root==null){
            return 0;
        }
        int max1= maxDepth(root.left);
        int max2 = maxDepth(root.right);

        return 1 + Math.max(max1,max2);
    }
}
