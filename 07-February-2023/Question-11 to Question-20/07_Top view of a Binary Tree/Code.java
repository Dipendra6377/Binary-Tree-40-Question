class Pair{
    Node node;
    int ind;
    Pair(Node node,int ind){
        this.node =node;
        this.ind=ind;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q =new LinkedList<>();
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair temp=q.poll();
            Node node=temp.node;
            int i =temp.ind;
            
            if(map.get(i)==null) map.put(i,node.data);
            
            if(node.left!=null) q.offer(new Pair(node.left,i-1));
            if(node.right!=null) q.offer(new Pair(node.right,i+1));
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet() ){
            list.add(entry.getValue());
        }
        return list;
    }
}
