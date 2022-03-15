class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length < 2) return true;
        
        HashMap<Integer, HashSet<Integer>> res = new HashMap<>();
        
        for (int i = 0; i < stones.length; i++) {
            res.put(stones[i],new HashSet<Integer>());
        }
        
        //initialize the map
        
        res.get(0).add(0);
        
        for (int i = 0 ; i < stones.length; i++) {
            int curr = stones[i];
            //different steps you can choose
            //int step = res.get(curr);
            
            for (int step: res.get(curr)) {
                //step -1
                if(res.containsKey(curr+step - 1) && step - 1 >0) {
                    res.get(curr+step-1).add(step-1);
 
                }
                //step
                if (res.containsKey(curr+step)) {
                    res.get(curr+step).add(step);
                }
                //step + 1
                if (res.containsKey(curr+step+ 1)) {
                    res.get(curr+step+1).add(step+1);
                }
            }
            
        }
        
        return !res.get(stones[stones.length-1]).isEmpty();
        
    }
}
