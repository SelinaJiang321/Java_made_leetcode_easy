class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        for (int i = 0; i < points.length; i++) {
            int[] entry = {distance(points[i]),i};
            if (pq.size() < k) {
                pq.offer(entry);
            } else if (entry[0] < pq.peek()[0]) {
                pq.poll();
                pq.offer(entry);
            }
        }
        
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int index = pq.poll()[1];
            res[i] = points[index];
        }
        return res;
        
    }
    
    public int distance(int[] point) {
        return point[0]*point[0] + point[1]* point[1];
    }
}
