class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        int yCnt = 0; 
        int pCnt = 0; 
        
        String str = s.toUpperCase();
        
        for(int i=0;i<str.length(); i++){
            if(str.charAt(i)=='Y'){
                yCnt++;
            }else if(str.charAt(i)=='P'){
                pCnt++;
            }
        }
        
        if(yCnt==pCnt){
            answer = true;
        }
        
        
        
        return answer;
    }
}
