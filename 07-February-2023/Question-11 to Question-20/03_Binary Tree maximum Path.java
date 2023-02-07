class Solution {
    public int maxPathSum(TreeNode root) {
        int max[] =new int[1];
        max[0] =Integer.MIN_VALUE;
        maxsum(root,max);
        return max[0];
    }
    public int maxsum(TreeNode root,int[] max){
        if(root==null){
            return 0;
        }

        int left=Math.max(0,maxsum(root.left,max));
        int right=Math.max(0,maxsum(root.right,max));

        max[0]=Math.max(max[0],left+right+root.val);

        return root.val + Math.max(left,right);
    }
}
