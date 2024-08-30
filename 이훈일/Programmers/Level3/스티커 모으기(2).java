class Solution {
    public static int solution(int[] sticker) {
        int len = sticker.length;
        int max = Integer.MIN_VALUE;
        
        if(len <= 3) {
            for(int i = 0; i < len; i++) {
                max = Math.max(max, sticker[i]);
            }
        } else {
            int[] dp1 = new int[len];
            int[] dp2 = new int[len];
            int[] dp3 = new int[len];
                
            dp1[1] = sticker[0];
            dp2[1] = sticker[1];
            dp3[2] = sticker[2];

            for(int i = 3; i < len; i++) {
                dp1[i] = sticker[i-1] + Math.max(dp1[i-2], dp1[i-3]);
                dp2[i] = sticker[i] + Math.max(dp2[i-2], dp2[i-3]);
                dp3[i] = sticker[i] + Math.max(dp3[i-2], dp3[i-3]);
            }

            int dp1Max = Math.max(dp1[len-2], dp1[len-1]);
            int dp2Max = Math.max(dp2[len-2], dp2[len-1]);
            int dp3Max = Math.max(dp3[len-2], dp3[len-1]);
            max = Math.max(Math.max(dp1Max, dp2Max), dp3Max);
        }
        
        return max;
    }
}
