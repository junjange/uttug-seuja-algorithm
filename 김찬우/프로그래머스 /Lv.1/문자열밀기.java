class Solution {
    public int solution(String A, String B) {
        
        int answer = -1;
        
        for(int i=A.length(); i>-1; i--){
            
            StringBuilder result = new StringBuilder(A);
            String subString = result.substring(i);
            System.out.println(subString);
            result.delete(i,A.length()+1);
            result.insert(0,subString);
             System.out.println(result.toString());
            
            if(result.toString().equals(B)){
                answer = A.length()-i;
                break;
            }
            
        }
        
        return answer;
    }
}
