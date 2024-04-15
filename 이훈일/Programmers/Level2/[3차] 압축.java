import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dic = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            dic.put(String.valueOf((char)('A'+i)), i+1);
        }
        
        int start = 0;
        List<Integer> answer = new ArrayList<>();
        while(start < msg.length()) {
            String cur = "";
            String pre = "";
            
            for(int i = start; i < msg.length(); i++) {
                cur += String.valueOf(msg.charAt(i));
                
                if(!dic.containsKey(cur)) {
                    dic.put(cur, dic.size()+1);
                    break;
                } 
                
                pre = cur;
            }
            
            answer.add(dic.get(pre));
            start += pre.length();
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}
