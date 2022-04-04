class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> counter_t = new HashMap<>();
        HashMap<Character, Integer> counter_s = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            int count = counter_t.getOrDefault(curr,0);
            counter_t.put(curr, count+1);
        }
        
        int left = 0;
        int valid = 0;
        int start = -1;
        int minlen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            if (counter_t.containsKey(curr)) {
                counter_s.put(curr, counter_s.getOrDefault(curr,0) + 1);
                //try to compare to characters
                if (counter_s.get(curr).compareTo(counter_t.get(curr)) == 0) {
                    valid++;
                }
            }
            while (valid == counter_t.size()) {
                if (right - left + 1 < minlen) {
                    start = left;
                    minlen = right - left+1;
                }
                //move left out
                // System.out.println(left);
                char left_ch = s.charAt(left);
                left++;
                //updating the table
                if (counter_t.containsKey(left_ch)) {
                    if (counter_t.get(left_ch).equals(counter_s.get(left_ch))) {
                        valid--;
                    }
                }
                counter_s.put(left_ch,counter_s.getOrDefault(left_ch,0)-1);
            }
        }
        if (start == -1) return "";
        return s.substring(start,start + minlen);
        
    }
}
