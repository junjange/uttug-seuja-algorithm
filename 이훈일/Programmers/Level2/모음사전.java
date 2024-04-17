class Solution {
    String[] words = new String[]{"A", "E", "I", "O", "U"};
    StringBuilder sb = new StringBuilder();
    String nWord;
    int count, answer;
    
    public int solution(String word) {
        answer = 0;
        count = 0;
        nWord = word;
        dfs(0);
        return answer;
    }
    
    public void dfs(int depth) {
        if(depth == 5) {
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            sb.append(words[i]);
            count++;
            if(sb.toString().equals(nWord)) {
                answer = count;
                return;
            }
            dfs(depth+1);
            sb.deleteCharAt(depth);
        }
    }
}
