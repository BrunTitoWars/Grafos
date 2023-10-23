package OrdenacaoTopologica;

import java.util.LinkedList;
import java.util.Stack;

public class NewDFS {
    private int numVertices;
    private LinkedList<Integer>[] adjList;
    private Stack<Integer> pilha; // Pilha global para armazenar a ordenação topológica

    public NewDFS(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    public Stack<Integer> ordem_top() {
        boolean[] visitado = new boolean[numVertices];
        pilha = new Stack<>();
        for (int i = 0; i < numVertices; ++i) {
            if (!visitado[i]) {
                dfsVisit(i, visitado);
            }
        }
        return pilha;
    }

    private void dfsVisit(int u, boolean[] visitado) {
        visitado[u] = true;
        for (Integer vizinho : adjList[u]) {
            if (!visitado[vizinho]) {
                dfsVisit(vizinho, visitado);
            }
        }
        pilha.push(u); // Adiciona o vértice na pilha ao final da visita
    }  
}
