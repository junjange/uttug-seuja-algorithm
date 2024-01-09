import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            String cloth_kind = clothes[i][1];
            if(map.containsKey(cloth_kind)) {
                map.put(cloth_kind, map.get(cloth_kind) + 1);
            } else {
                map.put(cloth_kind, 1);
            }
        }
        
        int sum = 1;
        for(String key : map.keySet()) {
            sum *= map.get(key) + 1;
        }
        
        return sum - 1;
    }
}
