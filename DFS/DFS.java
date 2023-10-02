package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS{
    
    private int V, E; //number of vertices and edges in the graph
    private LinkedList<Integer> adj[];
    private boolean visited[];
    private Stack stack = new Stack();
    private Queue queue = new Queue();

    private void dfs(int v){

        visited[v]=true;//marking vertex as visited
        stack.push(v);
        System.out.print(" "+stack.peek());

        for (int i:adj[v]) {
            if (!visited[i]){
                dfs(i);//recursive call
            }
        }
        while(!stack.isEmpty()){
            System.out.println("\n"+"popped element is : " + stack.pop() );
        }
    }                  
}