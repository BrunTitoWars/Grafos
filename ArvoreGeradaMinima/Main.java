import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Aresta {
    int origem, destino, peso;

    public Aresta(int origem, int destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
}

class Grafo {
    int V, E;
    List<Aresta> arestas;

    public Grafo(int V, int E) {
        this.V = V;
        this.E = E;
        arestas = new ArrayList<>();
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        Aresta aresta = new Aresta(origem, destino, peso);
        arestas.add(aresta);
    }
}

class Subset {
    int pai, rank;
}

public class Kruskal {
    int V, E;
    Grafo grafo;

    public Kruskal(int V, int E) {
        this.V = V;
        this.E = E;
        grafo = new Grafo(V, E);
    }

    int encontrar(Subset subsets[], int i) {
        if (subsets[i].pai != i) {
            subsets[i].pai = encontrar(subsets, subsets[i].pai);
        }
        return subsets[i].pai;
    }

    void unir(Subset subsets[], int x, int y) {
        int raizX = encontrar(subsets, x);
        int raizY = encontrar(subsets, y);

        if (subsets[raizX].rank < subsets[raizY].rank) {
            subsets[raizX].pai = raizY;
        } else if (subsets[raizX].rank > subsets[raizY].rank) {
            subsets[raizY].pai = raizX;
        } else {
            subsets[raizY].pai = raizX;
            subsets[raizX].rank++;
        }
    }

    void kruskalMST() {
        List<Aresta> resultado = new ArrayList<>();
        Subset subsets[] = new Subset[V];

        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].pai = v;
            subsets[v].rank = 0;
        }

        grafo.arestas.sort(Comparator.comparingInt(a -> a.peso));

        for (Aresta aresta : grafo.arestas) {
            int x = encontrar(subsets, aresta.origem);
            int y = encontrar(subsets, aresta.destino);

            if (x != y) {
                resultado.add(aresta);
                unir(subsets, x, y);
            }
        }

        System.out.println("Arestas da Árvore Geradora Mínima:");
        for (Aresta aresta : resultado) {
            System.out.println(aresta.origem + " - " + aresta.destino + ": " + aresta.peso);
        }
    }

    public static void main(String[] args) {
        int V = 4; // Número de vértices
        int E = 5; // Número de arestas
        Kruskal kruskal = new Kruskal(V, E);

        // Adicione as arestas do grafo com seus pesos
        kruskal.grafo.adicionarAresta(0, 1, 2);
        kruskal.grafo.adicionarAresta(0, 2, 3);
        kruskal.grafo.adicionarAresta(1, 2, 1);
        kruskal.grafo.adicionarAresta(1, 3, 4);
        kruskal.grafo.adicionarAresta(2, 3, 5);

        kruskal.kruskalMST();
    }
}
