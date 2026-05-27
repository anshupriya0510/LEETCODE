class Solution {
    public int numberOfSpecialChars(String word) {

        int count = 0;

        for(char ch = 'a'; ch <= 'z'; ch++) {

            boolean lower = false;
            boolean upper = false;
            boolean valid = true;

            int upperFirst = -1;

            for(int i = 0; i < word.length(); i++) {

                if(word.charAt(i) == Character.toUpperCase(ch)) {

                    if(upper == false) {
                        upperFirst = i;
                    }

                    upper = true;
                }

                if(word.charAt(i) == Character.toLowerCase(ch)) {

                    lower = true;

                    // lowercase after uppercase
                    if(upperFirst != -1 && i > upperFirst) {
                        valid = false;
                    }
                }
            }

            if(lower == true && upper == true && valid == true) {
                count++;
            }
        }

        return count;
    }
}