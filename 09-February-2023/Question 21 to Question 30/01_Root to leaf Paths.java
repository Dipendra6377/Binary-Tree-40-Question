class Tree{
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        if(root==null){
            return list;
        }
        ArrayList<Integer> temp=new ArrayList<>();
        
        path(list,temp,root);
        return list;
    }
    
    static void path(ArrayList<ArrayList<Integer>> list,ArrayList<Integer> temp,Node root){
        if(root==null){
            return;
        }
        temp.add(root.data);
        
        if(root.left==null && root.right==null){
            list.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        path(list,temp,root.left);
        path(list,temp,root.right);
        
        temp.remove(temp.size()-1);
    }
    
}
