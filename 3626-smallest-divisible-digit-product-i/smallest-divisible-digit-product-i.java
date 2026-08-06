class Solution {
    public int smallestNumber(int n, int t) {

        int ans = -1;

        while(true) {
            if(product(n) % t == 0) {
                return n;
            }
            n++;
        }

    }

    public long product(long val) {
        long rem = 0;
        long p = 1;
        while(val != 0) {
            rem = val % 10;
            p *= rem;
            val /= 10;
        }

        return p;
    }
}

// 10 11 12 13 14 ........... 20