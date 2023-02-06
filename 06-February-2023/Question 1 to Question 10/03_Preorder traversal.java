class BinaryTree
{
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        // Code here
        ArrayList<Integer> list=new ArrayList<>();
        findpreorder(root,list);
        return list;
    }
    static void findpreorder(Node root,ArrayList<Integer> list){
        if(root!=null){
            list.add(root.data);
            findpreorder(root.left,list);
            findpreorder(root.right,list);
        }
    }

}
