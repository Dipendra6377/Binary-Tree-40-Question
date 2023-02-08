import java.util.*;

class tree {
    int data;
    tree left, right;
    tree(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Tuple{
    tree node;
    int row;
    int col;
    Tuple(tree node,int row,int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}

public class Verical_Traversal_of_Binary_Tree {
    public static void main(String[] args) {
        tree root = new tree(1);
        root.left = new tree(2);
        root.left.left = new tree(4);
        root.left.right = new tree(10);
        root.left.left.right = new tree(5);
        root.left.left.right.right = new tree(6);
        root.right = new tree(3);
        root.right.left = new tree(9);
        root.right.right = new tree(10);

        List< List < Integer >> list = new ArrayList<>();
        list = findVertical(root);

        System.out.println("The Vertical Traversal is : ");
        for (List < Integer > it: list) {
            for (int nodeVal: it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> findVertical(tree root){

        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map= new TreeMap<>();
        Queue<Tuple> q=new LinkedList<Tuple>();

        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty()){
            Tuple temp=q.poll();
            tree node=temp.node;
            int x=temp.row;
            int y=temp.col;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap < > ());
                //System.out.println(map);
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue < > ());
                //System.out.println(map);
            }

            map.get(x).get(y).offer(node.data);

            if(node.left!=null){
                q.offer(new Tuple(node.left,x-1,y+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,x+1,y+1));
            }
        }
        //System.out.println("map " + map);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer,PriorityQueue<Integer>> level: map.values()){
            //System.out.println("level " + level);
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : level.values()){

                while(!nodes.isEmpty()){
                    //System.out.println("nodes : " + nodes);
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}
