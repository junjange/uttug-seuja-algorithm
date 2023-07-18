class Solution {
    public String solution(String s, int n) {
        char[] charArr = s.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            if(65 <= charArr[i] && charArr[i] <= 90) {
                if(charArr[i]+n > 90) {
                    charArr[i] = (char)(charArr[i]+n-26);
                } else{
                    charArr[i]= (char)(charArr[i]+n);
                }
            }else if(97 <= charArr[i] && charArr[i] <= 122 ){
                if(charArr[i]+n >122) {
                    charArr[i] = (char)(charArr[i]+n -26);
                } else{
                    charArr[i]= (char)(charArr[i]+n);
                }
            }
        }
        
        return new String(charArr);
    }
}
