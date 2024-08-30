import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int start = 0;
        int count = 0;  
        while(start < skill_trees.length) {
            String com = skill_trees[start];
            Queue<String> queue = new LinkedList<>();
            for(String sk : skill.split("")) {
                com = com.replaceAll(sk, "");
                queue.add(sk);
            }
            
            String skill_tree = skill_trees[start];
            String cur = queue.poll();
            for(String word : skill_tree.split("")) {
                if(cur.equals(word)) {
                    skill_tree = skill_tree.replaceAll(word, "");
                    if(!queue.isEmpty()) {
                        cur = queue.poll();
                    }
                }
            }
            
            if(skill_tree.equals(com)) {
                count++;
            }
            
            start++;
        }
        
        return count;
    }
}
