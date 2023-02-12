import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int data;
    TreeNode(int data){
        this.data=data;
    }
}

class pairs{
    TreeNode node;
    int n;
    pairs(TreeNode node,int n){
        this.node=node;
        this.n=n;
    }
}
public class Preorder_Inorder_Postorder_In_one_Traversal {
    public static void allTraversal(TreeNode root,List < Integer > pre, List < Integer > in , List < Integer > post){
        Stack<pairs> st=new Stack<pairs>();
        st.push(new pairs(root,1));
        if(root==null) return;

        while(!st.isEmpty()){
            pairs temp=st.pop();
            if(temp.n==1){
                pre.add(temp.node.data);
                temp.n++;
                st.push(temp);

                if(temp.node.left!=null){
                    st.push(new pairs(temp.node.left,1));
                }
            }

            else if(temp.n==2){
                in.add(temp.node.data);
                temp.n++;
                st.push(temp);

                if(temp.node.right!=null){
                    st.push((new pairs(temp.node.right,1)));
                }
            }
            else{
                post.add(temp.node.data);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List< Integer > pre = new ArrayList<>();
        List < Integer > in = new ArrayList < > ();
        List < Integer > post = new ArrayList < > ();
        allTraversal(root, pre, in , post);

        System.out.println("The preorder Traversal is : ");
        for (int nodeVal: pre) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The inorder Traversal is : ");
        for (int nodeVal: in ) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The postorder Traversal is : ");
        for (int nodeVal: post) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
    }
}
