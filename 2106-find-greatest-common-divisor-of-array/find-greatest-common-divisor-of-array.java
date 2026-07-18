class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);

        return find(nums[nums.length - 1], nums[0]);
        
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