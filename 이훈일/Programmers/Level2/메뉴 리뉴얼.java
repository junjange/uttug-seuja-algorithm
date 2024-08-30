import java.util.*;

class Solution {
    int target;
    String[] order, cooking;
    HashMap<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i < course.length; i++) {
            target = course[i];
            map = new HashMap<>();
            cooking = new String[target];
            
            for(int j = 0; j < orders.length; j++) {
                order = orders[j].split("");
                
                if(order.length >= target) {
                    Arrays.sort(order);
                    dfs(0, 0);
                }
            }
            
            if(map.size() > 0) {
                List<String> keys = new ArrayList<>(map.keySet());
                Collections.sort(keys, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return map.get(s2) - map.get(s1);
                    }
                });
                
                int first = map.get(keys.get(0));
                
                if(first > 1) {
                    result.add(keys.get(0));
                    
                    for(int j = 1; j < keys.size(); j++) {
                        if(first == map.get(keys.get(j))) {
                            result.add(keys.get(j));
                        }
                    }
                }
            }
        }
        
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public void dfs(int depth, int start) {
        if(depth == target) {
            String str = "";
            
            for(int i = 0; i < target; i++) {
                str += cooking[i];
            }
            
            if(map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
            
            return;
        }
        
        for(int i = start; i < order.length; i++) {
            cooking[depth] = order[i];
            dfs(depth+1, i+1);
        }
    }
}
