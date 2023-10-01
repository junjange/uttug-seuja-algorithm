import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        int result = 0;
        int count = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length;i++){
            
            if(map.containsKey(tangerine[i])){
                map.put(tangerine[i],map.get(tangerine[i])+1);
            }else{
                map.put(tangerine[i],1);
            }
            
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        
        for(Map.Entry<Integer, Integer> entry : entryList){
            
            result+=entry.getValue();
            
            if(result>=k){
                count++;
                break;
            }
            else{
                count++;
            }
            
        }
            
        return count;
    }
}
