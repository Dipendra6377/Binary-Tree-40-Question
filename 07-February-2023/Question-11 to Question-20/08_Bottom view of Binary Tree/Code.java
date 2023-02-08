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
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q =new LinkedList<>();
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair temp=q.poll();
            Node node=temp.node;
            int i =temp.ind;
            
            map.put(i,node.data);           // SAME AS TOP VIEW CODE ONLY THIS CHANGE
            
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
