class Solution {
    public int solution(String t, String p) {
        int count = 0;
        for(int i = 0; i <= t.length()-p.length(); i++){
            long sub = Long.parseLong(t.substring(i,i+p.length()));
            if(sub <= Long.parseLong(p)) {
                count++;
            }
        }

        return count;
    }
}
