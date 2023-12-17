class Solution {
    public int[] solution(int n, int[] info) {
        int dif = 0;
        int[] cur = new int[11];
        int[] result = new int[11];
        comb(n, 0, dif, cur, result, info);
        return result;
    }
    
    public static void comb(int n, int start, int dif, int[] cur, int[] result, int[] info) {
        
        if(start == 10) {
            return;
        }
        
        for(int i = start; i < cur.length; i++) {
            if(n >= info[i] + 1) {
                cur[i] = info[i]+ 1;
                n -= (info[i] + 1);
            }else {
                cur[10] = n;
                compare(dif, cur, result, info);
            }
            comb(n, start, dif, cur, result, info);
            n += cur[i];
            cur[i] = 0;
        }
    }
    
    public static void compare(int dif, int[] cur, int[] result, int[] info) {
        int curDif = 0;
        for(int i = 0; i < 11; i++) {
            if(info[i] < result[i]) {
                curDif += 10-i;                
            }else if(info[i] == result[i]){
                if(info[i] != 0) {
                    curDif -= 10-i;
                }
            }else {
                curDif -= 10-i;
            }
        }
        
        if(curDif > dif) {
            dif = curDif;
        }else if(curDif == dif) {
            for(int i = 10; i >= 0; i--) {
                if(cur[i] > result[i]) {
                    result = cur;
                }
            }
        }
    }
}
