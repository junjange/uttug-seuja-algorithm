class Solution {
    public int solution(String s) {
        int answer = 0;
        String result ="";
        String[] strArr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
     
        for(int j=0; j<strArr.length; j++){

           s = s.replace(strArr[j],String.valueOf(j));


        }
        
        return Integer.valueOf(s);
    }
}
