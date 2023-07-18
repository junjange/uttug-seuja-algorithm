class Solution {
    public String solution(int[] food) {
        
        String answer = "0";
        
        for(int i=1;i<food.length;i++){
            
            if(food[i]%2!=0){
                food[i]=(food[i]-1)/2;
            }else{
                food[i]=food[i]/2;
            }
            
        }
        
        for(int num : food){
             System.out.println(num);
        }
        
        for(int j=food.length-1;j>0;j--){
            String ad = String.valueOf(j);
            String eat = ad.repeat(food[j]);
             answer=answer+eat;
            answer=eat+answer;
        }
        
        
        
       
        
        
        return answer;
    }
}
