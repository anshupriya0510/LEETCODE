class Solution {

    public List<String> braceExpansionII(String expression) {

        Set<String> result = parseExpression(expression, new int[]{0});

        List<String> ans = new ArrayList<>(result);

        Collections.sort(ans);

        return ans;
    }

    // Handles comma / UNION
    private Set<String> parseExpression(String s, int[] index) {

        Set<String> result = new HashSet<>();

        while (index[0] < s.length()) {

            Set<String> part = parseTerm(s, index);

            // UNION
            result.addAll(part);

            if (index[0] < s.length() && s.charAt(index[0]) == ',') {
                index[0]++;
            } else {
                break;
            }
        }

        return result;
    }

    // Handles concatenation
    private Set<String> parseTerm(String s, int[] index) {

        Set<String> result = new HashSet<>();
        result.add("");

        while (index[0] < s.length()) {

            char ch = s.charAt(index[0]);

            // End of current expression
            if (ch == ',' || ch == '}') {
                break;
            }

            Set<String> current;

            // Braced expression
            if (ch == '{') {

                index[0]++; // skip {

                current = parseExpression(s, index);

                index[0]++; // skip }

            }
            // Single character
            else {

                current = new HashSet<>();
                current.add(String.valueOf(ch));

                index[0]++;
            }

            // Concatenate result with current
            Set<String> newResult = new HashSet<>();

            for (String a : result) {
                for (String b : current) {
                    newResult.add(a + b);
                }
            }

            result = newResult;
        }

        return result;
    }
}