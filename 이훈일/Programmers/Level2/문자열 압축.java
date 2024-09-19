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
        boolean isSame = false;
        int totalCnt = 0;
        int sameCnt = 0;
        for(int i = len; i < s.length(); i += len) {
            String cur = "";
            if(i+len > s.length()) {
                cur = s.substring(i);
            } else {
                cur = s.substring(i, i+len);
            }
            
            if(!pre.equals(cur)) {
                if(isSame) {
                    totalCnt += len + String.valueOf(sameCnt).length();
                } else {
                    totalCnt += len;
                }
                isSame = false;
            } else {
                if(isSame) {
                    sameCnt++;
                } else {
                    isSame = true;
                    sameCnt = 2;
                }
            }
            pre = cur;
        }
        
        if(isSame) {
            if(sameCnt > 9) {
                totalCnt += len + String.valueOf(sameCnt).length();
            } else {
                totalCnt += len + 1;
            }
        } else {
            totalCnt += pre.length();
        }
        
        return totalCnt;
    }
}
