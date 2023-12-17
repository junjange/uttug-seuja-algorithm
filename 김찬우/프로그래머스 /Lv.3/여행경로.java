import java.util.*;

class Solution {
    
    public static ArrayList<String> result;
    public static boolean[] visited;
    
    
    public String[] solution(String[][] tickets) {
        
 
        
        int cnt=0;
        visited = new boolean[tickets.length];
        result = new ArrayList<>();
        
        dfs("ICN","ICN",cnt,tickets);
        
        Collections.sort(result);
        
        String[] answer = result.get(0).split(" ");
        
        return answer;
    }
    public static void dfs(String start, String rout, int depth, String[][] tickets){
        
        if(depth == tickets.length){
            result.add(rout);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            
            
            if(tickets[i][0].equals(start) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], rout+" "+tickets[i][1],depth+1,tickets);
                visited[i] = false;
            }
            
            
        }
        
    }
    
    
}
