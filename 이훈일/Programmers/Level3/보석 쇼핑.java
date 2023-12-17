import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        for(String gem : gems) {
            set.add(gem);
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        int start = 0;
        int startPoint = 0;
        int length = Integer.MAX_VALUE;
        for(int i = 0; i < gems.length; i++) {
            if(map.containsKey(gems[i])) {
                map.put(gems[i], map.get(gems[i]) + 1);
            }else {
                map.put(gems[i], 1);
            }
            
            que.add(gems[i]);
            while(map.get(que.peek()) > 1) {
                map.put(que.peek(), map.get(que.peek())-1);
                que.poll();
                start++;
            }
            
            if(set.size()==map.keySet().size() && que.size() < length) {
                startPoint = start;
                length = que.size();
            }
        }
    
        return new int[]{startPoint + 1, startPoint + length};
    }
}
