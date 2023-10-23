package DFS;

import java.util.LinkedList;

public class DFSGrafo {

    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;
    
    public int[] ante;
    public int[] i;
    public int[] f;
    public int[] cor;
    public int tempo;

    private LinkedList< LinkedList<Integer> > grafo;

    public DFSGrafo(LinkedList< LinkedList<Integer> > grafo){

        this.grafo = grafo;
        int tamanhoGrafo = grafo.size();
        ante = new int[tamanhoGrafo];
        i = new int[tamanhoGrafo];
        f = new int[tamanhoGrafo];
        cor = new int[tamanhoGrafo];
    }
 
    public void dfs_start(int s){

        tempo = -1;
        
        for (int u = 0; u < grafo.size(); u++) {

            cor[u] = BRANCO;
            ante[u] = -2;
            i[u] = -2;
            f[u] = -2;
        }
        dfs_visit(s);

    }
    public void dfs_visit(int u){

        tempo++;
        i[u] = tempo;
        cor[u] = CINZA;

        LinkedList<Integer> prox = grafo.get(u);
        for (Integer v : prox) {
            if (cor[v] == BRANCO) {
                ante[v] = u;
                dfs_visit(v);
            }
        }
        tempo++;
        f[u] = tempo;
        cor[u] = PRETO;
    }
}
