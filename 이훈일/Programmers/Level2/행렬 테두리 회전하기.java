class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] graph = new int[rows][columns];
        int num = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                graph[i][j] = num;
                num++;
            }
        }
        
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;
            
            int min = Integer.MAX_VALUE;
            
            int pre = graph[x1][y1];
            int cur = 0;
            
            for(int j = y1+1; j <= y2; j++) {
                min = Math.min(graph[x1][j], min);
                cur = graph[x1][j];
                graph[x1][j] = pre;
                pre = cur;
            }
            
            for(int j = x1+1; j <= x2; j++) {
                min = Math.min(graph[j][y2], min);
                cur = graph[j][y2];
                graph[j][y2] = pre;
                pre = cur;
            }
            
            for(int j = y2-1; j >= y1; j--) {
                min = Math.min(graph[x2][j], min);
                cur = graph[x2][j];
                graph[x2][j] = pre;
                pre = cur;
            }
            
            for(int j = x2-1; j >= x1; j--) {
                min = Math.min(graph[j][y1], min);
                cur = graph[j][y1];
                graph[j][y1] = pre;
                pre = cur;
            }
            
            result[i] = min;
        }
        
        return result;
    }
}
