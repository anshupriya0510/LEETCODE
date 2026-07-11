import java.util.*;

class Solution {

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int completeCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] res = dfs(i, adj, visited);
                int nodes = res[0];
                int edgeCount = res[1];

                // each edge counted twice in DFS (degree sum)
                edgeCount /= 2;

                if (edgeCount == nodes * (nodes - 1) / 2) {
                    completeCount++;
                }
            }
        }

        return completeCount;
    }

    private int[] dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        int nodes = 1;
        int edges = adj.get(node).size();

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                int[] res = dfs(nei, adj, visited);
                nodes += res[0];
                edges += res[1];
            }
        }

        return new int[]{nodes, edges};
    }
}