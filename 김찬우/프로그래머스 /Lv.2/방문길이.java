import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        HashSet<String> set = new HashSet<String>();
        
        int nowX = 5;
        int nowY = 5;
        
        for(int i=0; i<dirs.length(); i++){
            
            int nextX = nowX;
            int nextY = nowY;
            String road = "";
            
            if(dirs.charAt(i) == 'U'){
                nextY--;
                road+=nextX;
                road+=nextY;
                road+=nowX;
                road+=nowY;
                
            }else if(dirs.charAt(i) == 'D'){
                
                nextY++;
                road+=nowX;
                road+=nowY;
                road+=nextX;
                road+=nextY;
                
            }else if(dirs.charAt(i) == 'R'){
                nextX++;
                road+=nowX;
                road+=nowY;
                road+=nextX;
                road+=nextY;
                
            }else{
                nextX--;
                road+=nextX;
                road+=nextY;
                road+=nowX;
                road+=nowY;
            }
            
            if(nextX < 0 || nextX > 10|| nextY < 0 || nextY > 10 ){
                continue;
            }
            
            set.add(road);
            nowX = nextX;
            nowY = nextY;
            
        }
            
        
        return set.size();
    }
}
