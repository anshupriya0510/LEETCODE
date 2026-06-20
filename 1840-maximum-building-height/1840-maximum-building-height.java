import java.util.Arrays;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;

        // If there are no restrictions, the height can simply
        // increase by 1 for each consecutive building.
        if (m == 0) {
            return n - 1;
        }

        // Sort restrictions by building index.
        Arrays.sort(restrictions, (a, b) -> Integer.compare(a[0], b[0]));

        // ---------------- Left -> Right ----------------
        // The first restricted building cannot exceed
        // (buildingIndex - 1) because building 1 has height 0.
        restrictions[0][1] = Math.min(restrictions[0][1],
                                      restrictions[0][0] - 1);

        // Tighten every restriction using the previous restriction.
        for (int i = 1; i < m; i++) {
            int distance = restrictions[i][0] - restrictions[i - 1][0];
            int maxAllowedHeight = restrictions[i - 1][1] + distance;

            restrictions[i][1] = Math.min(restrictions[i][1], maxAllowedHeight);
        }

        // ---------------- Right -> Left ----------------
        // Tighten every restriction using the next restriction.
        for (int i = m - 2; i >= 0; i--) {
            int distance = restrictions[i + 1][0] - restrictions[i][0];
            int maxAllowedHeight = restrictions[i + 1][1] + distance;

            restrictions[i][1] = Math.min(restrictions[i][1], maxAllowedHeight);
        }

        int answer = 0;

        // -------- Before the first restriction --------
        answer = Math.max(answer,
                (restrictions[0][1] + restrictions[0][0] - 1) / 2);

        // -------- Between consecutive restrictions --------
        for (int i = 1; i < m; i++) {

            int posA = restrictions[i - 1][0];
            int heightA = restrictions[i - 1][1];

            int posB = restrictions[i][0];
            int heightB = restrictions[i][1];

            int distance = posB - posA;

            // Maximum possible peak between these two restrictions.
            int peak = (heightA + heightB + distance) / 2;

            answer = Math.max(answer, peak);
        }

        // -------- After the last restriction --------
        int lastPos = restrictions[m - 1][0];
        int lastHeight = restrictions[m - 1][1];

        answer = Math.max(answer, lastHeight + (n - lastPos));

        return answer;
    }
}