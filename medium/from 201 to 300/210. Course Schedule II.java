/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.


*/

class Solution {
    
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;
    
    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer>topologicalOrder;
    
    
    private void init(int numCourses) {
        this.isPossible = true;
        this.color = new HashMap<Integer,Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();
        
        //default color are white
        for (int i = 0 ; i < numCourses; i++) {
            this.color.put(i,WHITE);
        }
    }
    
    private void dfs(int node) {
        
        //if we found a cycle ,return
        if (!this.isPossible) {
            return;
        }
        
        //start the recursion by turning the color to grey
        this.color.put(node,GRAY);
        
        //traverse neighbouring vertices
        
        for (Integer neighbor: this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
            if (this.color.get(neighbor) == GRAY) {
                // a cycle has been formed here
                this.isPossible = false;
            } else if (this.color.get(neighbor) == WHITE) {
                this.dfs(neighbor);
            }
        }
        
        // recursion ends, we mark it as black
        
        this.color.put(node,BLACK);
        this.topologicalOrder.add(node);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.init(numCourses);
        
        //create the adjacency list of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src,lst);
            
        }
        
        //if the node is white, then call dfs
        for (int i = 0; i< numCourses; i++) {
            if (this.color.get(i) == WHITE) {
                this.dfs(i);
            }
        }
        
        int [] order;
        if (this.isPossible) {
            order = new int[numCourses];
            for (int i = 0;i < numCourses; i++) {
                // so hard
                order[i] = this.topologicalOrder.get(numCourses -i-1);
            }
        } else {
            order = new int[0];
        }
        return order;
    }
    
}
