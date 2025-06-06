public class IslandsCounter {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);

        // Direcciones para moverse: arriba, abajo, izquierda, derecha
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // Unir con celdas adyacentes que también sean tierra
                    for (int[] dir : directions) {
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];

                        if (newRow >= 0 && newRow < m &&
                                newCol >= 0 && newCol < n &&
                                grid[newRow][newCol] == '1') {

                            uf.union(i * n + j, newRow * n + newCol);
                        }
                    }
                }
            }
        }

        return uf.getCount();
    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            count = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        parent[id] = id;
                        count++;
                    }
                }
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // compresión de ruta
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                // Unión por rango
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        // Ejemplo 1
        char[][] grid1 = {
                {'1','1','1','0','0'},
                {'1','1','1','0','0'},
                {'1','1','1','0','0'},
                {'0','0','0','1','0'},
                {'0','0','0','0','1'}
        };

        // Ejemplo 2
        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','1','0'},
                {'0','0','0','1','1'}
        };

        System.out.println("Ejemplo 1:");
        System.out.println(numIslands(grid1));

        System.out.println("\nEjemplo 2:");
        System.out.println(numIslands(grid2));
    }
}