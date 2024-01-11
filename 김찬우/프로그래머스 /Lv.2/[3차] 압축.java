import java.util.*;
class Solution {
    public int[] solution(String msg) {
        
        Map<String,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        int k = 1;
        for(char i = 'A'; i<='Z'; i++){
            
            map.put(i+"", k);
            k++;
            
        }
        
        int start = 0;
        int end = 1; 
    
        while(end <=msg.length()){
            
           String str =  msg.substring(start,end);
            
            if(map.containsKey(str)){
                
                end++;
                
                if(end > msg.length()){
                     list.add(map.get(msg.substring(start,end-1)));
                     break;
                }
                
                continue;
                
            }
            
            list.add(map.get(msg.substring(start,end-1)));

            start = end-1;
            
            map.put(str,k);
            
            k++;
             
        
        }
        

        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
