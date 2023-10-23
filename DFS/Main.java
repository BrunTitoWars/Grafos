package DFS;

public class Main {

    public static void main(String[] args) {
        // Exemplo de uma matriz de adjacência para um grafo não direcionado
        boolean[][] grafo = {
                {false, true, true, false, false},
                {true, false, true, true, false},
                {true, true, false, false, true},
                {false, true, false, false, true},
                {false, false, true, true, false}
        };

        // Vértice de origem para iniciar a busca em profundidade (DFS)
        int verticeOrigem = 0;

        // Criar um objeto DFSGrafo com a matriz de adjacência
        DFSGrafo dfsGrafo = new DFSGrafo(grafo);

        // Executar a busca em profundidade a partir do vértice de origem
        dfsGrafo.dfs_start(verticeOrigem);

        // Exibir os resultados da busca em profundidade
        System.out.println("Resultados da busca em profundidade a partir do vértice " + verticeOrigem + ":");
        for (int i = 0; i < grafo.length; i++) {
            System.out.println("Vértice " + i + ": Início = " + dfsGrafo.i[i] + ", Fim = " + dfsGrafo.f[i] + ", Antecessor = " + dfsGrafo.ante[i]);
        }
    }
}
