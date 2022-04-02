class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> nums = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        
        nums.offer(1L);
        seen.add(1L);

        long num = 1L;
        for (int i = 1; i < n; i++) {
            num = nums.poll();
            
            if (!seen.contains(num * 2)) {
                nums.offer(num * 2);
                seen.add(num * 2);
            }
            
            if (!seen.contains(num * 3)) {
                nums.offer(num * 3);
                seen.add(num * 3);
            }
            
            if (!seen.contains(num * 5)) {
                nums.offer(num * 5);
                seen.add(num * 5);
            }
        }
        
        return nums.poll().intValue();
        
    }
}
