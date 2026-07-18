class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        generatePermutations(nums, 0, list);
        return list;
    }

    public void generatePermutations(int[] nums, int ind, List<List<Integer>> list) {
        if(nums.length == ind) {
            ArrayList<Integer> l = new ArrayList<>();
            for(var i : nums) {
                l.add(i);
            }
            list.add(new ArrayList<>(l));
            return;
        }

        for(int i = ind;i < nums.length;i++) {
            swap(nums, ind, i);
            generatePermutations(nums, ind + 1, list);
            swap(nums, ind, i);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}