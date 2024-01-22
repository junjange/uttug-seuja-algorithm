import java.util.*;

class Solution {
    
    static boolean[] visited = new boolean[1000001];
    
    public int solution(int x, int y, int n) {
        
        int cnt = -1;
        
        
        Queue<int[]> queue =  new LinkedList<>();
        
        queue.offer(new int[]{x,0});
        visited[x] = true;
        
        while(!queue.isEmpty()){
            
            int[] node = queue.poll();
            
            
            if(node[0] == y){
                cnt = node[1];
                break;
                
            }
            
            if(node[0]+n <= y &&  !visited[node[0]+n]){
                visited[node[0]+n] = true;
                queue.offer(new int[]{node[0]+n , node[1]+1});
                
            }
            
            if(node[0]*2<= y &&  !visited[node[0]*2]){
                visited[node[0]*2] = true;
                queue.offer(new int[]{node[0]*2 , node[1]+1});
                
            }
            
            if(node[0] * 3 <= y &&  !visited[node[0]*3]){
                visited[node[0]*3] = true;
                queue.offer(new int[]{node[0]*3 , node[1]+1});
                
            }
            
        }
        
    
        return cnt;
    }
}
