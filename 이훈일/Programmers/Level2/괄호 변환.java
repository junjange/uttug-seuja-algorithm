import java.util.*;

class Solution {
    public String solution(String p) {
        return dfs(p);
    }
    
    public String dfs(String w) {
        if(w.length() == 0) {
            return "";
        }
        
        Queue<String> queue = new LinkedList<>();
        String[] words = w.split("");
        queue.add(words[0]);
        
        int index = 1;
        String u = words[0];
        while(!queue.isEmpty()) {
            if(words[index].equals(queue.peek())) {
                queue.add(words[index]);
            } else {
                queue.poll();
            }
            u += words[index];
            index++;
        }
        String v = w.substring(index);
        
        if(isCorrect(u)) {
            return u + dfs(v);
        } else {
            return changeStr(u, v);
        }
    }
    
    public boolean isCorrect(String u) {
        if(u.charAt(0) == ')') {
            return false;
        }
        
        Queue<String> queue = new LinkedList<>();
        String[] uArr = u.split("");
        for(int i = 0; i < uArr.length; i++) {
            if(uArr[i].equals("(")) {
                queue.add(uArr[i]);
            } else {
                if(queue.isEmpty()) {
                    return false;
                } else {
                    queue.poll();
                }
            }
        }
        
        return true;
    }
    
    public String changeStr(String u, String v) {
        String result = "(";
        result += dfs(v);
        result += ")";
        
        for(int i = 1; i < u.length()-1; i++) {
            if(u.charAt(i) == '(') {
                result += ")";
            } else {
                result += "(";
            }
        }
        
        return result;
    }
}
