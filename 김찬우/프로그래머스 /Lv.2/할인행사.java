import java.util.*;


class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            
            map.put(want[i],number[i]);
            
        } 
        
        int j = 0;
        int result = 0;
       
        
        while(j <= discount.length-10){
            
            boolean check = true;
            
            HashMap<String, Integer> hashmap = new HashMap<>();
            
            for(int k=0; k<10 ;k++){
                
                
                //System.out.println("discount[j+k] "+discount[j+k]);
                
                if(hashmap.containsKey(discount[j+k])){
                    hashmap.put(discount[j+k],hashmap.get(discount[j+k])+1);
                }
                else{
                    hashmap.put(discount[j+k],1);
                }
                
            }
        
            j++;
           
            
            for(int i = 0; i < want.length; i++){
                
                if(map.get(want[i]) != hashmap.get(want[i])){
                    check = false;
                    break;
                }
            
            }
            
            if(check){
                result++;
            }
            
        }
        
        return result;
    }
}
