import java.lang.Math;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        long resl = 0;
        
        for(int i=1;i<=count;i++){
            
            resl+= price*i;
            
        }
        
        if(money-resl<0){
            return (money-resl)*-1;
        }
        

        return 0;
    }
}
