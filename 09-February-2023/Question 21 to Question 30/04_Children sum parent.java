 public static int isSumProperty(Node root)
    {
        // add your code here
        if(root==null) return 1;
        int x=0;
        int y=0;
        if(root.left!=null){
            x=root.left.data;
        }
        if(root.right!=null){
            y=root.right.data;
        }
        if(x==0&& y==0){x=root.data;}
        if(x+y!=root.data){
            return 0;
        }
        int left=1;
        int right=1;
        if(root.left!=null) {left=isSumProperty(root.left);}
        if(root.right!=null){right=isSumProperty(root.right);}
    
        
        return left & right;
    }
}
