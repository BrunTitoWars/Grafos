package BFS;

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

        // Vértice de origem para iniciar a busca em largura
        int verticeOrigem = 0;

        // Criar um objeto BFSGrafo com a matriz de adjacência
        BFSGrafo bfsGrafo = new BFSGrafo(grafo);

        // Executar a busca em largura a partir do vértice de origem
        bfsGrafo.bfs(verticeOrigem);

        // Exibir os resultados da busca em largura
        System.out.println("Resultados da busca em largura a partir do vértice " + verticeOrigem + ":");
        for (int i = 0; i < grafo.length; i++) {
            System.out.println("Vértice " + i + ": Distância = " + bfsGrafo.d[i] + ", Antecessor = " + bfsGrafo.ante[i]);
        }
    }
}
