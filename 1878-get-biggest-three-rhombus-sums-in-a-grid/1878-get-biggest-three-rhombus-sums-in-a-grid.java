import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> set = new HashSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                // size 0 rhombus
                set.add(grid[r][c]);

                for (int k = 1; r - k >= 0 && r + k < m && c - k >= 0 && c + k < n; k++) {

                    int sum = 0;

                    int x = r - k, y = c;

                    // top -> right
                    for (int i = 0; i < k; i++)
                        sum += grid[x + i][y + i];

                    // right -> bottom
                    for (int i = 0; i < k; i++)
                        sum += grid[x + k + i][y + k - i];

                    // bottom -> left
                    for (int i = 0; i < k; i++)
                        sum += grid[x + 2 * k - i][y - i];

                    // left -> top
                    for (int i = 0; i < k; i++)
                        sum += grid[x + k - i][y - k + i];

                    set.add(sum);
                }
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        int size = Math.min(3, list.size());
        int[] res = new int[size];

        for (int i = 0; i < size; i++)
            res[i] = list.get(i);

        return res;
    }
}