
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        
        for(String str : participant){
            
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);
            }
            
            
        }
     
        
        for(String str : completion){
            
            if(map.containsKey(str)){
                map.put(str,(map.get(str)-1));
            }
        }
 
        
        for(String str : participant){
            
            if(map.get(str) == 1){
                result +=str;
                break;
            }
            
            
        }
    
        
        return result;
    }
}
