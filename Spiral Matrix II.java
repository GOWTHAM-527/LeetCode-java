class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1;
        int colBegin = 0, colEnd = n - 1;
        int num = 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int j = colBegin; j <= colEnd; j++) res[rowBegin][j] = num++;
            rowBegin++;

            for (int j = rowBegin; j <= rowEnd; j++) res[j][colEnd] = num++;
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) res[rowEnd][j] = num++;
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) res[j][colBegin] = num++;
            }
            colBegin++;
        }
        return res;
    }
}