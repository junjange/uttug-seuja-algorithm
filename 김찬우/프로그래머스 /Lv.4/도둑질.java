import java.lang.Math;

class Solution {
    public int solution(int[] money) {
        
       int mlen = money.length;
        
        int[] first = new int[mlen];
        int[] second = new int[mlen];
            
        for(int i = 0; i<mlen; i++){
            first[i] = money[i]; 
            second[i] = money[i]; 
        }
        
        // 3번째 까지는 미리 넣기 
        first[0] = money[0];
        first[1] = 0;
        first[2] +=first[0];
        second[0] = 0;
        second[1] = money[1];

        for(int j = 3; j<mlen;j++){
            
            first[j] += Math.max(first[j-2],first[j-3]);
            second[j] += Math.max(second[j-2],second[j-3]);
            
        }
        
        int firstMax = Math.max(first[mlen-2],first[mlen-3]);
        int secondMax = Math.max(second[mlen-1],second[mlen-2]);
        
        
       return Math.max(firstMax,secondMax);
        
        
    }
}
