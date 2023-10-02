package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFSGrafo {

    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;

    public int[] ante;
    public int[] d;
    public int[] cor;

    private LinkedList<LinkedList<Integer>> grafo;

    public BFSGrafo(LinkedList<LinkedList<Integer>> grafo) {
        this.grafo = grafo;
        int numVertices = grafo.size();
        ante = new int[numVertices];
        d = new int[numVertices];
        cor = new int[numVertices];
    }

    public void bfs(int s) {
        for (int u = 0; u < grafo.size(); u++) {
            cor[u] = BRANCO;
            d[u] = Integer.MAX_VALUE;
            ante[u] = -1;
        }

        cor[s] = CINZA;
        d[s] = 0;
        ante[s] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            LinkedList<Integer> adjacents = grafo.get(u);

            for (int v : adjacents) {
                if (cor[v] == BRANCO) {
                    cor[v] = CINZA;
                    d[v] = d[u] + 1;
                    ante[v] = u;
                    queue.add(v);
                }
            }

            cor[u] = PRETO;
        }
    }
}
