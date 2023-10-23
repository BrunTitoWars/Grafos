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

    private boolean[][] grafo;

    public BFSGrafo(boolean[][] grafo) {
        this.grafo = grafo;
        int numVertices = grafo.length;
        ante = new int[numVertices];
        d = new int[numVertices];
        cor = new int[numVertices];
    }

    public void bfs(int s) {
        int numVertices = grafo.length;
        for (int u = 0; u < numVertices; u++) {
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
            for (int v = 0; v < numVertices; v++) {
                if (grafo[u][v] && cor[v] == BRANCO) {
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
