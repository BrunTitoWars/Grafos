package BFS;

import java.util.LinkedList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        // Exemplo de uso
        LinkedList<LinkedList<Integer>> grafo = new LinkedList<>();
        int numVertices = 6; // Defina o número de vértices do seu grafo

        for (int i = 0; i < numVertices; i++) {
            grafo.add(new LinkedList<>());
        }

        // Adicione as arestas ao seu grafo
        grafo.get(0).add(1);
        grafo.get(0).add(2);
        grafo.get(1).add(3);
        grafo.get(2).add(4);
        grafo.get(3).add(5);

        BFSGrafo execucao = new BFSGrafo(grafo);
        execucao.bfs(0);
        
        // Você pode acessar as distâncias e o antecessor de cada vértice
        for (int u = 0; u < numVertices; u++) {
            System.out.println("Vértice " + u + ": Distância=" + execucao.d[u] + ", Antecessor=" + execucao.ante[u]);
        }
    }
    
}