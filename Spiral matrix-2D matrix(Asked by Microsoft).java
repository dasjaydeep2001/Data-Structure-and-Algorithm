class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) { // c1 to c2
                list.add(matrix[r1][i]);
            }
            for (int i = r1 + 1; i <= r2; i++) { // r1+1 to r2
                list.add(matrix[i][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int i = c2 - 1; i >= c1; i--) { // c2-1 to c1
                    list.add(matrix[r2][i]);
                }
                for (int i = r2 - 1; i >= r1 + 1; i--) { // r2-1 to r1+1
                    list.add(matrix[i][c1]);
                }
            }
            c1++;
            c2--;
            r1++;
            r2--;
        }
        return list;
    }
} // TC: O(m*n), SC: O(m*n)

 /*     c1     c2    
 r1 [[1,  2,  3],
     [4,  5,  6],
     [7,  8,  9]] r2 */
