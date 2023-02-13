
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        TreeNode root=find(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);

        return root;
    }

    public TreeNode find(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend,Map<Integer,Integer> map){
        if(prestart>preend || instart>inend) return null;

        TreeNode root = new TreeNode(preorder[prestart]);

        int inroot= map.get(root.val);
        int num=inroot-instart;

        root.left = find(preorder,prestart+1,num+prestart,inorder,instart,inroot-1,map);

        root.right = find(preorder,prestart+num+1,preend,inorder,inroot+1,inend,map);

        return root;

    }
}
