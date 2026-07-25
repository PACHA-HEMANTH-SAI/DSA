class Solution {
    public int maxProduct(int n) {
        int temp = n;
        int rem = 0;
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        
        while(temp != 0) {
            rem = temp % 10;
            if(rem > max) {
                smax = max;
                max = rem;
            }else if(rem > smax) {
                smax = rem;
            }
            temp /= 10;
        }

        return (smax * max);

    }
}