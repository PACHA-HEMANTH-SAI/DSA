class Solution {
    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        boolean isLower = false;
        boolean isUpper = false;
        boolean isDigit = false;
        boolean isSpecial = false;
        boolean isAdjacent = false;

        if(n < 8) return false;
        
        for(int i= 0; i < n; i++) {
                char ch = password.charAt(i);

                if(Character.isLowerCase(ch)) {
                    isLower = true;
                }
                if(Character.isUpperCase(ch)) {
                    isUpper = true;
                }
                if(Character.isDigit(ch)) {
                    isDigit = true;
                }
                if((ch == '!') || (ch == '@')  || (ch == '#')  || (ch == '$') || (ch == '!')  || (ch == '!')  || (ch == '!')  || (ch == '%')  || (ch == '^')  || (ch == '&')  || (ch == '*')  || (ch == '(') || (ch == ')') || (ch == '-') || (ch == '+') ) {
                    isSpecial = true;
                }

                if((i <= n-2) && (password.charAt(i) == password.charAt(i+1))) {
                    isAdjacent = true;
                }

        }

        if(isLower && isUpper && isDigit && isSpecial && !isAdjacent) {
            return true;
        }

        else {
            return false;
        }
    }
}