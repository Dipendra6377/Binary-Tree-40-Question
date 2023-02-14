// Recursive
//Time Complexity: O(N)   Space Complexity: O(N)
class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        
        if(root==null){
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right=prev;
        root.left=null;
        prev=root;
    }
}


// Iterative using stack
//Time Complexity: O(N)   Space Complexity: O(N)

class Solution {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
       Stack<TreeNode> st=new Stack<>();
       st.push(root);

       while(!st.isEmpty()){
           TreeNode temp=st.pop();
           if(temp.right!=null){
               st.push(temp.right);
           }

           if(temp.left!=null){
               st.push(temp.left);
           }
           if(!st.isEmpty()){
               temp.right =st.peek();
           }
           temp.left=null;
       } 
    }
}


//oprimized solution
//Time Complexity: O(N)   Space Complexity: O(1)



class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr=root;
        
        while(curr!=null){
            if(curr.left!=null){
                TreeNode prev=curr.left;

                while(prev.right!=null){
                prev=prev.right;
                }
                prev.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            
            curr=curr.right;
        }
    }
}
