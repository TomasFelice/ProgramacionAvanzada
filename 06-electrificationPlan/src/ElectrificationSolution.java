import java.util.*;

public class ElectrificationSolution {

    static class Edge {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        // Leer las ciudades con centrales eléctricas
        boolean[] hasPowerPlant = new boolean[n + 1];
        for (int i = 0; i < k; i++) {
            int city = sc.nextInt();
            hasPowerPlant[city] = true;
        }

        // Leer la matriz de costos
        int[][] cost = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        // Algoritmo de Prim modificado
        boolean[] inMST = new boolean[n + 1];
        int[] minCost = new int[n + 1];
        int[] parent = new int[n + 1];

        // Inicializar con valores infinitos
        Arrays.fill(minCost, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Marcar todas las ciudades con centrales como ya incluidas en el MST
        // y actualizar los costos mínimos desde estas ciudades
        for (int i = 1; i <= n; i++) {
            if (hasPowerPlant[i]) {
                inMST[i] = true;
                minCost[i] = 0;

                // Actualizar costos desde esta central eléctrica
                for (int j = 1; j <= n; j++) {
                    if (!inMST[j] && cost[i][j] < minCost[j]) {
                        minCost[j] = cost[i][j];
                        parent[j] = i;
                    }
                }
            }
        }

        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;

        // Construir el MST
        for (int count = 0; count < n - k; count++) {
            // Encontrar el vértice con costo mínimo que no esté en el MST
            int u = -1;
            for (int i = 1; i <= n; i++) {
                if (!inMST[i] && (u == -1 || minCost[i] < minCost[u])) {
                    u = i;
                }
            }

            if (u == -1) break;

            inMST[u] = true;
            totalCost += minCost[u];

            if (parent[u] != -1) {
                mstEdges.add(new Edge(parent[u], u, minCost[u]));
            }

            // Actualizar costos mínimos desde el nuevo vértice añadido
            for (int v = 1; v <= n; v++) {
                if (!inMST[v] && cost[u][v] < minCost[v]) {
                    minCost[v] = cost[u][v];
                    parent[v] = u;
                }
            }
        }

        // Imprimir resultado
        System.out.println(totalCost);
        for (Edge edge : mstEdges) {
            System.out.println(edge.from + " " + edge.to);
        }

        sc.close();
    }
}