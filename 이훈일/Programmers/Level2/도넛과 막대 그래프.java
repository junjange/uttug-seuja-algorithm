import java.util.*;

class Solution {
    static HashMap<Integer, int[]> graphInfo = new HashMap<>();
    static int[] answer;
    
    public static int[] solution(int[][] edges) {
        makeGraph(edges);
        
        answer = new int[4];
        findGraph();
        
        return answer;
    }
    
    public static void makeGraph(int[][] edges) {
        for(int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            
            if(graphInfo.containsKey(start)) {
                graphInfo.get(start)[0]++;
        
            } else {
                graphInfo.put(start, new int[]{1, 0});
            }
            
            if(graphInfo.containsKey(end)) {
                graphInfo.get(end)[1]++;
            } else {
                graphInfo.put(end, new int[]{0, 1});
            }
        }
    }
    
    public static void findGraph() {
        int graphCnt = 0;
        for(int node : graphInfo.keySet()) {
            int[] info = graphInfo.get(node);
            int outCnt = info[0];
            int intCnt = info[1];
            
            if(intCnt == 0 && outCnt >= 2) {
                answer[0] = node;
            } else if(outCnt == 0) {
                answer[2]++;
                graphCnt++; 
            } else if(intCnt >= 2 && outCnt == 2) {
                answer[3]++;
                graphCnt++;
            } 
        }
        
        int startNode = answer[0];
        answer[1] = graphInfo.get(startNode)[0] - graphCnt;
    }
}
