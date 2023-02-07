class Solution
{
    boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }
    
    void findLeftBoundary(Node root,ArrayList<Integer> res){
        Node cur=root.left;
        
        while(cur!=null){
            if(isLeaf(cur)==false) res.add(cur.data);
            if(cur.left!=null) cur=cur.left;
            else cur=cur.right;
        }
    }
    void findRightBoundary(Node root,ArrayList<Integer> res){
        ArrayList<Integer> temp=new ArrayList<>();
        
        Node cur=root.right;
        while(cur!=null){
            if(isLeaf(cur)==false) temp.add(cur.data);
            if(cur.right!=null) cur=cur.right;
            else cur=cur.left;
        }
        
        for(int i=temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }
    
    void findLeafBoundary(Node root,ArrayList<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        
        if(root.left!=null) findLeafBoundary(root.left,res);
        if(root.right!=null) findLeafBoundary(root.right,res);
    }
	ArrayList <Integer> boundary(Node root)
	{
	    ArrayList<Integer> res=new ArrayList<>();
	    if(isLeaf(root)==false) res.add(root.data) ;
	    
	    
	    findLeftBoundary(root,res);
	    findLeafBoundary(root,res);
	    findRightBoundary(root,res);
	    return res;
	}
}
