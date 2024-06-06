import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int mok=n;
        
        List<Integer> num=new ArrayList<>();
        //10진수->3진수
        while(mok!=0) {
        	num.add(mok%3);
        	mok=mok/3;
        }
        //3진수->10진수
        int cnt=num.size()-1;
        for(int i:num) {
        	answer+=(int) (i*Math.pow(3,cnt--));
        }
        
        return answer;
    }
}
