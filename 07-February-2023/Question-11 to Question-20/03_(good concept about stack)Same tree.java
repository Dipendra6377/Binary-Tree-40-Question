// Iterative approach using stack
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // right here to see if node is null or not if we push null in stack it will not show empty  
        if( p == null ||  q == null ) {
            if( p == null && q == null ) {
                return true;
            }
            return false;
        }
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();

        st1.push(p); st2.push(q);
        //even if you push null value in stack stack will not show empty thts why on top we have to see if any root node is null else it will throw error and show node value emty
        while(!st1.isEmpty()){
            TreeNode temp1=st1.pop();
            TreeNode temp2=st2.pop();
            // right here bcoz temp1 value is none it will throw error in case p=[] and q = [0]
            if(temp1.val!=temp2.val){
                return false;
            }
            if((temp1.left==null && temp2.left!=null) || (temp1.left!=null && temp2.left==null) ){  // xor ^ also be used in this place
                return false;
            }

            if(temp1.left!=null && temp2.left!=null){
                st1.push(temp1.left);
                st2.push(temp2.left);
            } 

            if((temp1.right==null && temp2.right!=null) || (temp1.right!=null && temp2.right==null) ){
                return false;
            }
        
            if(temp1.right!=null && temp2.right!=null){
                st1.push(temp1.right);
                st2.push(temp2.right); 
            }
            
        }
        return true;
    }
}



// recursive approach

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        // if (p == null && q != null || p != null && q == null){
        //     return false;
        // } SAME TO SAME AS BELOW USING XOR

        //p==null(T) && q==null(T) OK  p!=null(F) && q!=null(F) OK

        //but p==null (T) && q!=null (F) it will got in it and show false
        //but p!=null (F) && q==null (T) it will got in it and show false 
        
        if(p==null ^ q==null){    // HOW xor HELP ??  TRUTH TABLE   
            return false;         //  T F =T  && T T =F  && F T = T && F F =F
        }
        if(p.val!=q.val){
            return false;
        }

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
