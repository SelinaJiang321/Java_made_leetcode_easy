class RandomizedSet {
    private HashSet<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if (set.contains(val)) return false;
        set.add(val);
        return true;
        
    }
    
    public boolean remove(int val) {
        if (!set.contains(val)) return false;
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
       // solution - using a list to get the element
        
        List<Integer> curr = new ArrayList<>(set);
        Random random = new Random();
        return curr.get(random.nextInt(set.size()));
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
