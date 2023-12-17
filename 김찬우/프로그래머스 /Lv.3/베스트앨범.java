import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {

        
        Map<String, HashMap<Integer,Integer>> map = new HashMap<>();
        
        HashMap<String,Integer> hash = new HashMap<>();
        
        List<Integer> result = new ArrayList<>();
        
        
        for(int i =0; i < genres.length; i++){
            
            if(hash.containsKey(genres[i])){
                hash.put(genres[i], hash.get(genres[i]) + plays[i]);
                map.get(genres[i]).put(i,plays[i]);
                
            }else{
                HashMap<Integer,Integer> hashMap = new HashMap<>();
                hashMap.put(i,plays[i]);
                hash.put(genres[i], plays[i]);
                map.put(genres[i],hashMap);
            }       
        }
        
        List<String> list = new ArrayList<>(hash.keySet());
        
        list.sort((o1,o2) -> hash.get(o2) - hash.get(o1));
        
   
        System.out.println(map);
  
        
        for(int i = 0; i<list.size(); i++){
            
            String key = list.get(i);
            
            HashMap<Integer,Integer> newMap = map.get(key);
            
            System.out.println(newMap);
        
            List<Integer> li = new ArrayList<>(newMap.keySet());
            
            li.sort((o1,o2) -> newMap.get(o2) - newMap.get(o1));
            
            result.add(li.get(0));
            
            if(li.size() > 1){
                result.add(li.get(1));
            }
            
        }

        
        return result;
    }
}
