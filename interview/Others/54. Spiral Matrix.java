class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix[0].length == 0 || matrix.length == 0) return result;
        
        
        int left = 0;
        int right = matrix[0].length -1;
        int up = 0;
        int down = matrix.length - 1;
        
        while (left <= right && up <= down) {
            for (int j = left; j <= right && up <= down; j++) {
                result.add(matrix[up][j]);
            }
            up++;
            for (int j = up; j <= down && left <= right; j++) {
                result.add(matrix[j][right]);
            }
            right--;
            
            for (int i = right; i>= left && up <= down; i--) {
                result.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= up && left <= right; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
        
        
    }
}
