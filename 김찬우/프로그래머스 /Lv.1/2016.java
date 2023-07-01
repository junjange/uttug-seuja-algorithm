class Solution {
    public String solution(int a, int b) {
        
    
       
        int result = 0;
        
        int[] month = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
        
        String[] answer = {"FRI","SAT","SUN","MON","TUE","WED","THU",};
        
        for( int i = 1;i<a;i++){
            System.out.println(i);
            result+=month[i];
        }
        
        result = (result-1+b)%7;
        
        
        return answer[result];
    }
}
