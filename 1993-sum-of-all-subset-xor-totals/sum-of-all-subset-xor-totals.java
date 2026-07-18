class Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        generateSubsets(nums, 0, list);
        return sum;
    }

    public void generateSubsets(int[] nums, int ind, List<Integer> list) {
        if(ind == nums.length) {
            int xor = 0;
            for(var i : list) {
                xor ^= i;
            }

            sum += xor;

            return;
        }

        generateSubsets(nums, ind + 1, list);
        list.add(nums[ind]);
        generateSubsets(nums, ind + 1, list);
        list.remove(list.size() - 1);
    }
}