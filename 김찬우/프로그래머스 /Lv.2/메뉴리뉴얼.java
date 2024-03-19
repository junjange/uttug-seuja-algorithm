import java.util.*;

class Solution {
    
    static HashMap<String,Integer> map = new HashMap<>();
    static ArrayList<String> result = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
      
        for(int cnt : course){
            
            for(String order : orders){
                
                char[] cArr = order.toCharArray();
                
                Arrays.sort(cArr);
                
                dfs(0,"",cArr,cnt);
                
            }
            
            if(!map.isEmpty()){
                int max = Collections.max(map.values());
                
                if(max > 1){
                    
                    for(String key : map.keySet()){
                    
                        if(map.get(key) == max){
                            
                            result.add(key);
                        }
                    
                    }
                    
                }
                
                
                  
            }
            
    
            
            map.clear();
            
            
        }
        
        String[] answer = new String[result.size()];
        
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    static void dfs(int depth, String course, char[] order, int count){
        
        
        if(course.length() == count){
            
            if(map.containsKey(course)){
                
                map.put(course, map.get(course) + 1);
            }
            else{
                map.put(course,1);
            }
            
            return;
            
        }
        
        if(depth >= order.length){
            return;
        }
        
        
        dfs(depth+1, course + order[depth], order, count);
        dfs(depth+1, course, order, count);
        
        
    }
}
