class Solution {
    static String[] dic;
    static String tar;
    static int answer;
    static boolean[] visited;
    
    public static int solution(String begin, String target, String[] words) {
        dic = new String[words.length];
        for(int i = 0; i < words.length; i++) {
            dic[i] = words[i];
        }
        
        tar = target;
        answer = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        dfs(0, begin);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public static void dfs(int count, String word) {
        if(word.equals(tar)) {
            answer = Math.min(answer, count);    
            return;
        }
        
        for(int i = 0; i < dic.length; i++) {
            if(!visited[i]) {
                if(isPossible(word, dic[i])) {
                    visited[i] = true;
                    dfs(count + 1, dic[i]);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static boolean isPossible(String word, String com) {
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != com.charAt(i)) {
                count++;
            }
        }
        
        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }
}
