class Solution {
    public int solution(int num, int k) {
        
        String strNum = "" + num;
        String strK = ""+ k;
        
        int result = strNum.indexOf(strK);
        
        return (result==-1) ? -1 : result+1;
    
    }
}
