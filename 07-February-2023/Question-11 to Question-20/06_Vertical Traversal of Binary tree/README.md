<img src="https://lh3.googleusercontent.com/_cAzrnqpfqycZ8os8nqq0SD-YGbtIuUSxWMgw-bI0uLM-Tffjtca8hFnHLjG0cN5hMVJwWo7CZGdH8XGc5IgZx-e8P_ThA0BphuC08fbaolhsyOCGc00VxOE-Hu-5LgOTb_Fxic1" alt="tree" width="600" height="300">

<<img src="https://lh6.googleusercontent.com/lKSl_VwDV3YG21t5wSeSGpqstch64pxUEmRVtqk7AblDuIaNymTwUWuSwjMyUHCHNaEpUmTrzpyrLFGi1XfI2l4LcikOmOVQ_YM6r4STZNw5nSkWv9RwfMi8zqWIzkdGHobdFF8G" alt="Map" width="600" height="300">>

<p1> In the vertical order traversal, we need to print the nodes of the left vertical first, therefore in our example, nodes of -2 vertical will be the first to  be printed. Therefore, we need a data structure that can store nodes according to their vertical value and give us the nodes of least values first. Hence we will use a map as it satisfies both criterias.</p1>

<h2> <strong>1st </strong> we have to make <code> map<Vertical,X> </code> so that we can store vertical index there in Treemap</h2>
  <p1><code> Why Tree Map???</code> bcoz unlike HashMap ,treemap store in incresing order index like -1,-2,0,1,2 and give you in order wise order </p1>
  
  <pre>
  if (!map.containsKey(x)) {
      map.put(x, new TreeMap < > ());
      System.out.println(map);
  }
  </pre>
  
  <h2> so how it will store value in Treemap </h2>
  <pre>
  {0={}}
  {-1={}, 0={}}
  {-1={}, 0={}, 1={}}
  {-2={}, -1={}, 0={}, 1={}}
  {-2={}, -1={}, 0={}, 1={}, 2={}}
  </pre>
  
  <p1>Now, we will explore X. In a single vertical we want to get the nodes by their levels. In our example, vertical 0 has nodes of three different levels, we will print level 0 first (node 1), then level 2 (node 9 and 10) and at last level 4 (node 6). Therefore as in the case of our verticals, we will again use map to store nodes level-wise inside the vertical. So, our data structure will become:</p2>
  
  <code >map<Vertical,Map<level,Y>>  </code>
  
  <p1>Now, we will explore Y. There can be a case that two or more nodes overlap at the same vertical and level, as with case of node 9 and node 10 at vertical 0 and level 2. In such a case we will print nodes with lesser value first. Therefore for every level, we need a data-structure which can store node values in a sorted order. Moreover, as duplicate values are allowed in our tree, our data structure needs to handle this well. This is acheived by using multiset in C++. Multiset is similar to a set which keeps elements in sorted order but also allows duplicates. In Java, we can use priority queues as it gives us the minimum value at the top.

Therefore, our final data structure will be:</p1>

<code> TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>  </code>

<strong > in code how it store values </store>
<pre>  
if (!map.containsKey(x)) {
       map.put(x, new TreeMap < > ());
       //System.out.println(map);
   }
if (!map.get(x).containsKey(y)) {
       map.get(x).put(y, new PriorityQueue < > ());
       System.out.println(map);
   }  
   </pre>
   
<pre>{-2={2=[]},
-1={1=[], 3=[]},
0={0=[], 2=[], 4=[]}, 
1={1=[]}, 
2={2=[]}
}
</pre>

<p> Now in priority queue we have to store node value in priority </p>

<pre>
map.get(x).get(y).offer(node.data);

</pre>

<p> So how it store node value in output </p>

<pre>
{-2={2=[4]},
-1={1=[2], 3=[5]},
0={0=[1], 2=[9, 10], 4=[6]}, 
1={1=[3]}, 
2={2=[10]}
} 
</pre>

<pre>
{vertical index ={level = [Node value ]}}
{tree Map { verticalIndex, TreeMap (level , Priority Queue })}
</pre>
