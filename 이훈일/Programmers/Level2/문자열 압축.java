class Solution {
    public static int solution(String s) {
        int result = Integer.MAX_VALUE;
        for(int i = 1; i <= s.length(); i++) {
            result = Math.min(compress(s, i), result);
        }
        
        return result;
    }
    
    public static int compress(String s, int len) {
        String pre = s.substring(0, len);
        int totalCnt = 0;
        int sameCnt = 1;
        for(int i = len; i < s.length(); i += len) {
            String cur = "";
            if(i+len > s.length()) {
                cur = s.substring(i);
            } else {
                cur = s.substring(i, i+len);
            }
            
            if(!pre.equals(cur)) {
                if(sameCnt > 1) {
                    totalCnt += len + String.valueOf(sameCnt).length();
                } else {
                    totalCnt += len;
                }
                sameCnt = 1;
            } else {
                sameCnt++;
            }
            pre = cur;
        }
        
        if(sameCnt > 1) {
            totalCnt += pre.length() + String.valueOf(sameCnt).length();
        } else {
            totalCnt += pre.length();
        }
        
        return totalCnt;
    }
}
