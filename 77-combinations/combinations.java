class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        generateCombinations(n, k, 1, list, l);
        return list;
    }

    public void generateCombinations(int n, int k, int ind, List<List<Integer>> list, List<Integer> l) {
        if(ind == (n+1)) {
            if(l.size() == k) {
                list.add(new ArrayList<>(l));
            }
            return;
        }

        generateCombinations(n, k, ind + 1, list, l);
        l.add(ind);
        generateCombinations(n, k, ind + 1, list, l);
        l.remove(l.size() - 1);
    }
}