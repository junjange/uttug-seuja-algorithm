import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int[] startPoint = new int[2];
        int[] curIndex = new int[2];
        
        
        Map<Character, int[]> role = new HashMap<>(){{
            put('N', new int[]{-1,0});
            put('S', new int[]{1,0});
            put('W', new int[]{0,-1});
            put('E', new int[]{0,1});
        }};
        
        
        for(int i = 0; i<park.length ;i++){     
            
            int index = park[i].indexOf("S");
            
            if(index != -1){
                startPoint[0] = i;
                startPoint[1] = index;
            }
            
        }
    
        
        for(int j = 0; j < routes.length; j++){
            
            int num = routes[j].charAt(2)-'0';
            int[] movement = role.get(routes[j].charAt(0));
            // int[] curIndex = startPoint;
            curIndex[0] = startPoint[0];
            curIndex[1] = startPoint[1];
            boolean checkBreak = false;
            
        
            for(int k = 1; k <= num; k++){
            
                curIndex[0]+=movement[0];
                curIndex[1]+=movement[1];
                
                if(curIndex[0] >= park.length || curIndex[1] >= park[0].length() || curIndex[0] < 0 || curIndex[1] < 0 ){
                    
                    checkBreak = true;
                    break;
                
                }
                
                if(park[curIndex[0]].charAt(curIndex[1])=='X'){
                    
                    checkBreak = true;
                    break;
                }

                
            }
            
            if(!checkBreak){
                 startPoint[0]=curIndex[0];
                 startPoint[1]=curIndex[1];
            }
            
        }    
       
        return startPoint;
    }
}
