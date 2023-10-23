package OrdenacaoTopologica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Ordenacao {

    private int numVertices;
    private LinkedList<Integer>[] adjList;

    public Ordenacao(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (Integer neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }
        stack.push(v);
    }

    public List<Integer> topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; ++i) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}