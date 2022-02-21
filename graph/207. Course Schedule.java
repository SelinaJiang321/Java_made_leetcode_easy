/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

*/

// L ← Empty list that will contain the sorted elements
// S ← Set of all nodes with no incoming edges
// while S is non-empty do

// remove a node n from S
// add n to tail of L
// for each node m with an edge e from n to m do
// remove edge e from the graph
// if m has no other incoming edges then
// insert m into S
// if graph has edges then
// return error (graph has at least one cycle)
// else
// return L (a topologically sorted order)


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];
        List<Integer>[] goCourses = new List[numCourses];
        for(int i=0;i<goCourses.length;i++){
            goCourses[i] = new LinkedList<Integer>();
        }
        for(int[] pair: prerequisites){
            incomingEdges[pair[0]]++;
            goCourses[pair[1]].add(pair[0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<incomingEdges.length;i++){
            if(incomingEdges[i]==0){
                queue.add(i);
            }
        }
        int edgeCnt = prerequisites.length;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int goCrs: goCourses[cur]){
                 edgeCnt--;
                incomingEdges[goCrs]--;
                 if(incomingEdges[goCrs]==0)
                    queue.add(goCrs);
            }
        }
        return edgeCnt==0;
    }
}
