class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int max = Integer.MIN_VALUE;
        int ind = -1;

        for(int i = 0;i < n;i++) {
            int count = 0;

            for(int j = 0;j < m;j++) {
                if(mat[i][j] == 1) count++;
            }

            if(count > max) {
                max = count;
                ind = i;
            }
        }

        int result[] = new int[2];

        result[0] = ind;
        result[1] = max;

        return result;
    }
}