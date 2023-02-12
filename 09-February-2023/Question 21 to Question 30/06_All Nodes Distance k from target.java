/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map= new HashMap<>();
        linkParentWithChild(root,map,target);
        Map<TreeNode,Boolean> visited=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(target);
        visited.put(target,true);
        int currk=0;

        while(!q.isEmpty()){
            int size=q.size();
            if(currk++ == k) break;

            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();

                if(curr.left!=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }

                if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(map.get(curr)!=null && visited.get(map.get(curr))==null){
                    q.offer(map.get(curr));
                    visited.put(map.get(curr),true);
                }
            }
        }
        List<Integer> list=new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            list.add(temp.val);
        }
        return list;

    }

    public void linkParentWithChild(TreeNode root,Map<TreeNode,TreeNode> map ,TreeNode target){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp.left!=null){
                map.put(temp.left,temp);
                q.offer(temp.left);
            }
            if(temp.right!=null){
                map.put(temp.right,temp);
                q.offer(temp.right);
            }
        }
    }
}
