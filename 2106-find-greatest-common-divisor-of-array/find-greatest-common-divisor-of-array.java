class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0;i < nums.length;i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        return find(max, min);
        
    }

    public int find(int a, int b) {
        int r = 0;
        int q = 0;

        while(b != 0) {
            q = a / b;
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }


}