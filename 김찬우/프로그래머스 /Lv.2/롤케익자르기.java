import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        HashSet<Integer> set= new HashSet<>();
        
        int answer = 0;
        
        for(int i=0; i<topping.length; i++){
            
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
            
        }
        
        
        
        for(int i=0; i<topping.length; i++){
            
           int a = map.get(topping[i]);
           set.add(topping[i]);
            
            if(a-1 ==0 ){
                map.remove(topping[i]);
            }else{
                map.put(topping[i],a-1);
            }
            
           
           if(map.size() == set.size()){
               answer++;
           }
            
            
        }
        
        
       
        return answer;
    }
}
