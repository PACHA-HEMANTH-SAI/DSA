class Solution {
    public boolean isBalanced(String num) {
        int even = 0;
        int odd = 0;
        for(int i = 0; i < num.length();i++) {
            if((i + 1) % 2 == 0) even = even + Integer.parseInt(num.charAt(i) + "");
            else 
            odd = odd + Integer.parseInt(num.charAt(i) + "");
        }

        return even == odd;
    }
}