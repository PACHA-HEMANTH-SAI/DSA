class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Pair arr[] = new Pair[capital.length];

        for(int i = 0;i < profits.length; i++) {
            arr[i] = new Pair(capital[i],profits[i]);
        }

        Arrays.sort(arr, (a, b) ->{
            if(a.capital != b.capital) return a.capital - b.capital;
            return b.profit - a.profit;
        });
            

        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;

        while(k != 0) {
            while(index < arr.length) {
                if(arr[index].capital > w) {
                    break;
                }

                pq.add(arr[index].profit);
                index++;
            }

            if(pq.isEmpty()) {
                return w;
            }

            else {
                int x = pq.poll();
                result += x;
                w += x;
                k--;
            }
        }
        return w;
    }
}

class Pair {
    int capital;
    int profit;

    public Pair(int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
    }

}