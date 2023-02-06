class Tree
{
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
       // Your code goes here
       Stack<Node> st1=new Stack<>();
       Stack<Node> st2=new Stack<>();
       ArrayList<Integer> list=new ArrayList<>();
       
       if(root==null) return list;
       st1.push(root);
       
       while(!st1.isEmpty()){
           Node temp=st1.pop();
           st2.push(temp);
           
           if(temp.left!=null) st1.push(temp.left);
           if(temp.right!=null) st1.push(temp.right);
       }
       
       while(!st2.isEmpty()){
           list.add(st2.pop().data);
       }
    
       return list;
       
    }
}
