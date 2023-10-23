package OrdenacaoTopologica;

import java.util.Stack;

public class Main{

    public static void main(String[] args) {
        NewDFS grafo = new NewDFS(6);
        grafo.addEdge(5, 2);
        grafo.addEdge(5, 0);
        grafo.addEdge(4, 0);
        grafo.addEdge(4, 1);
        grafo.addEdge(2, 3);
        grafo.addEdge(3, 1);

        Stack<Integer> ordenacaoTopologica = grafo.ordem_top();
        System.out.println("Ordenação Topológica usando DFS: " + ordenacaoTopologica);
    }
}