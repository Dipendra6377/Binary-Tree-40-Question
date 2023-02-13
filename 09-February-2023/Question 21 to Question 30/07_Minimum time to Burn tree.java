class Solution
{
    public static int findTreeBurnTime(HashMap<Node,Node> map,Node target){
        Queue<Node> q=new LinkedList<>();
        q.offer(target);
        HashMap<Node,Boolean> vis = new HashMap<>();
        int time=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            int flag=0;
            
            for(int i=0;i<size;i++){
                Node node = q.poll();
                
                if(node.left!=null && vis.get(node.left)==null){
                    flag=1;
                    vis.put(node.left,true);
                    q.offer(node.left);
                }
                
                if(node.right!=null && vis.get(node.right)==null){
                    flag=1;
                    vis.put(node.right,true);
                    q.offer(node.right);
                }
                
                if(map.get(node)!=null && vis.get(map.get(node))==null){
                    flag=1;
                    vis.put(map.get(node),true);
                    q.offer(map.get(node));
                }
            }
            if(flag==1){
                time++;
            }
        }
        return time;
    }
    public static Node mapchildToparent(Node root,HashMap<Node,Node> map,int target){
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        Node res=null;
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.data==target) res=curr;
            if(curr.left!=null){
                map.put(curr.left,curr);
                q.offer(curr.left);
            }
            
            if(curr.right!=null){
                map.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
        return res;
    }
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        
        HashMap<Node,Node> map=new HashMap<>();
        Node start=mapchildToparent(root,map,target);
        int time =findTreeBurnTime(map,start);
        return time;
    }
}
