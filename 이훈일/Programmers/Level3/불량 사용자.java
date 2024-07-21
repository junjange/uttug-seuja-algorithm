import java.util.*;

class Solution {
    static String[] users, banUsers, result;
    static List<String[]> results;
    static boolean[] visited;
    
    public static int solution(String[] user_id, String[] banned_id) {
        users = user_id.clone();
        banUsers = banned_id.clone();
        result = new String[banUsers.length];
        results = new ArrayList<>();
        visited = new boolean[users.length];
        
        dfs(0);
        
        return results.size();
    }
    
    public static void dfs(int depth) {
        if(depth == result.length) {
            String[] clone = result.clone();
            
            Arrays.sort(clone);

            boolean getSameArr = false;
            for(int i = 0; i < results.size(); i++) {
                String[] comp = results.get(i);
                
                if(isSameArr(comp, clone)) {
                    getSameArr = true;
                    break;
                } 
            }
            
            if(!getSameArr) {
                results.add(clone);
            }
            
            return;
        }
        
        for(int i = 0; i < users.length; i++) {
            String user = users[i];
            String banUser = banUsers[depth];
            
            if(isSame(user, banUser) && !visited[i]) {
                visited[i] = true;
                result[depth] = user;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isSame(String user, String banUser) {
        if(user.length() != banUser.length()) {
            return false;
        }
        
        for(int i = 0; i < banUser.length(); i++) {
            if(banUser.charAt(i) != '*') {
                if(user.charAt(i) != banUser.charAt(i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static boolean isSameArr(String[] comp, String[] clone) {
        for(int i = 0; i < comp.length; i++) {
            if(!comp[i].equals(clone[i])) {
                return false;
            }
        }
        
        return true;
    }
}
