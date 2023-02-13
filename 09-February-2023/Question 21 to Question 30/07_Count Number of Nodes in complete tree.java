// Time complexity O(N)

class Solution {
    public int countNodes(TreeNode root) {
        int count[] = new int[1];
        count(root,count);
        return count[0];

    }
    public void count(TreeNode root,int[] count){
        if(root==null){
            return ;
        }

        count[0]++;
        count(root.left,count);
        count(root.right,count);
    }
}


// TIME COMPLEXITY O(logN * logN)   SC O(logN)

class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left = findleftheight(root);
        int right= findrightheight(root);

        if(left ==right) return((2<<(left))-1);

        else return countNodes(root.left)+countNodes(root.right)+1;

    }

    public int findleftheight(TreeNode root){
        int count=0;
        while(root.left!=null){
            count++;
            root=root.left;
        }
        return count;
    }

    public int findrightheight(TreeNode root){
        int count=0;
        while(root.right!=null){
            count++;
            root=root.right;
        }
        return count;
    }
}
