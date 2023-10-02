package DFS;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        DFS g1 = new DFS(4);
        g1.addEdge(0 , 2);
        g1.addEdge(0 , 3);
        g1.addEdge(1 , 2);
        g1.addEdge(2 , 0);
        g1.addEdge(2 , 3);
        g1.addEdge(3 , 3);
        g1.dfs_iterative();//for iterative approach
        g1.dfs(g1.V-1); 
    }
    
}