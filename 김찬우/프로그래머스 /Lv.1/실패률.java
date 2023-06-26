import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        Map<Integer, Double> map = new HashMap<>();
        
        int reachedP = 0;
        
        int falseClear = 0;
        
        double result;
    
        for(int i =1; i<=N;i++){
            
             reachedP = 0;
             falseClear = 0;

            for(int num : stages){
                
                if(num>=i){
                    reachedP+=1;
                 }
                
                if(i==num){
                falseClear +=1;
                }
                
            }
            
            if(reachedP == 0 ){
                result = 0;
                map.put(i, result);
                continue;
            }
            
            result = (double)falseClear/reachedP;
            map.put(i, result);
                         
            
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
         keySet.sort(new Comparator<>() {
            
             @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        
       
        
        return keySet.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
   

    
}
