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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        
        if(root==null) return list;
        q.offer(root);
        boolean position =true;

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> sublist=new ArrayList<>(size);
            for(int i=0;i<size;i++){
                int index=i;
                
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                if(position==true) sublist.add(q.poll().val); // 1 2 3 4
                else sublist.add(0,q.poll().val);     // print in reverse   4 3 2 1
            }
            position= !position;
            list.add(sublist);
        }
        return list;
    }
}
