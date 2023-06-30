import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int choose = nums.length/2;
        
        int answer = 0;
        
        for(int poket : nums){
            
            if(map.containsKey(poket)){
                map.put(poket,map.get(poket)+1);
            }
            else{
                map.put(poket,1);
            }
        }
        
        if(map.size() < choose){
            return map.size();
        }
        else {
            return choose;
        }
        
    
    }
    
}
