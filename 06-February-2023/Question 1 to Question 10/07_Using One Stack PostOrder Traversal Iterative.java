class Tree {
    ArrayList<Integer> postOrder(Node root) {
        // code here
        Stack<Node> st=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();
        
        if(root==null) return list;
        
        st.push(root);
        
        while(!st.isEmpty()){
            Node temp=st.pop();
            list.add(temp.data);
            
            if(temp.left!=null) st.push(temp.left);
            if(temp.right!=null) st.push(temp.right);
        }
        Collections.reverse(list);
        return list;
    }
}
