import java.util.*;

class Solution {

    public String lexGreaterPermutation(String s, String target) {

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        // Try changing target from right to left
        for (int i = target.length() - 1; i >= 0; i--) {

            // Characters before i must match target
            String prefix = target.substring(0, i);

            // Check whether prefix can be made using s
            int[] freq = new int[26];

            for (char c : arr) {
                freq[c - 'a']++;
            }

            boolean possible = true;

            for (char c : prefix.toCharArray()) {
                if (freq[c - 'a'] == 0) {
                    possible = false;
                    break;
                }
                freq[c - 'a']--;
            }

            if (!possible) {
                continue;
            }

            // Find smallest character > target[i]
            for (int c = target.charAt(i) - 'a' + 1; c < 26; c++) {

                if (freq[c] > 0) {

                    StringBuilder ans = new StringBuilder(prefix);

                    // Put the bigger character
                    ans.append((char) ('a' + c));
                    freq[c]--;

                    // Put remaining characters in sorted order
                    for (int j = 0; j < 26; j++) {
                        while (freq[j] > 0) {
                            ans.append((char) ('a' + j));
                            freq[j]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}