import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        
        Map<String, HashMap<Integer,Integer>> map = new HashMap<>();
        
        HashMap<String,Integer> hash = new HashMap<>();
        
        
        for(int i =0; i < genres.length; i++){
            

            if(hash.containsKey(genres[i])){
                hash.put(genres[i], hash.get(genres[i]) + plays[i]);
                hashMap.put(i,plays[i]);
            }else{
                HashMap<Integer,Integer> hashMap = new HashMap<>();
                hashMap.put(i,plays[i]);
                hash.put(genres[i], plays[i]);
                //map.put(genres[i],)
            }       
        }
        
        List<String> list = new ArrayList<>(hash.keySet());
        
        list.sort((o1,o2) -> hash.get(o2) - hash.get(o1));
        
        for(int i=0; i<list.size(); i++){
            
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            String key = list.get(i);
            
            for(int j=0; j<genres.length; j++){
                
                if(key.equals(genres[j])){
                    hashMap.put(j,plays[j]);
                    
                }else{
                    continue;
                }
                
            }
            map.put(key,hashMap);
            
            
        }
        
         List<String> keys =  new ArrayList<>(map.keySet());
        
      
        
        
        

        int[] answer = {};
        
        return answer;
    }
}
