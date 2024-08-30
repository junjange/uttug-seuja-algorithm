import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        
        HashMap<String,Integer> map = new HashMap<>();
        char lastA = words[0].charAt(words[0].length()-1); 
        map.put(words[0],1);
        
        int[] answer = new int[2];
        
        for(int i=1; i<words.length; i++){
            
            
            if(map.containsKey(words[i]) || 
               words[i].charAt(0) != lastA){
                
                answer[0] = i % n + 1;
                
                answer[1] = i / n +1;
                
                break;
                
                
            }else{
                lastA = words[i].charAt(words[i].length()-1);
                map.put(words[i],1);
            }
            
        }
        
        

        return answer;
    }
}
