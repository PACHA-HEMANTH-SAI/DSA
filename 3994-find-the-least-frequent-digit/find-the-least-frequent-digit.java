class Solution {
    public int getLeastFrequentDigit(int n) {
        String s = n + "";
        HashMap<Character,Integer> map = new HashMap<>();
        char ans = '$';
        int min = Integer.MAX_VALUE;
        for(int i= 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(var i : map.entrySet()) {
            if(i.getValue() < min) {
                min = i.getValue();
                ans = i.getKey();
            }
        }
        String result =  ans + "";
        return Integer.parseInt(result);
    }
}