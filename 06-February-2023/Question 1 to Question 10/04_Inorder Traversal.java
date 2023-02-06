class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        findpreorder(root,list);
        return list;
    }

    static void findpreorder(TreeNode root,List<Integer> list){
        if(root!=null){
            findpreorder(root.left,list);
            list.add(root.val);
            findpreorder(root.right,list);
        }
    }
}
