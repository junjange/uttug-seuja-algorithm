import java.util.*;
class Solution {
    
    static int[] dx ={1,-1,0,0};
    static int[] dy ={0,0,1,-1};
    static List<Integer> result = new ArrayList<>();
    static String[] maps;
    static boolean[][] visited;
    static int count = 0;
    
    public int[] solution(String[] maps) {
        this.maps = maps;
        
       visited =  new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                
                if(maps[i].charAt(j) != 'X' && !visited[i][j]){
                    count = 0;
                    visited[i][j] = true;
                    dfs(i,j);
                    
                    result.add(count);
                }
                
            }
        }
        Collections.sort(result);
        
        int[] answer = new int[result.size()];
        
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        if(result.size() == 0 ){
            answer = new int[]{-1};
        }
        
        return answer;
    }
    
    public static void dfs(int x, int y){
       
        visited[x][y] = true;
        count+= maps[x].charAt(y)-'0';
        
        for(int i=0; i<4; i++){
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            
            if(nx >= 0 && nx<maps.length && ny >=0 && ny<maps[0].length()){
                
                if(maps[nx].charAt(ny) != 'X' && !visited[nx][ny]){
                    dfs(nx,ny);
                }
                
            }
            
            
            
            
        }
        
        
    }
}
