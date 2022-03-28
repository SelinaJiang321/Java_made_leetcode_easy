class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
            
        }
        
        int j = 0;
        int k = 1;
        int min = Integer.MAX_VALUE;
        
        while (j < sum.length && k < sum.length) {
    
            if (sum[k] - sum[j] >= target) {

                min = Math.min(min,k - j);
                j++;
            }
            else  {
                k++;
            }
        }
        
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
        
    }
}
