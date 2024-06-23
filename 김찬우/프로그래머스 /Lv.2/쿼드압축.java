class Solution {
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        
        
        backTrack(arr,0,arr.length-1,0,arr.length-1);
        
        return answer;
    }
    
    public void backTrack(int[][] arr, int startX,int endX,int startY,int endY){
        
        boolean check = true;
        
        int one = arr[startX][startY];
        
        loop:
        for(int i=startX; i<=endX; i++){
            
            for(int j=startY; j<=endY; j++){
                
                if(one != arr[i][j]){
                    check = false;
                    break loop;
                }
                
                
            }
            
        }
        
        if(check){
            answer[one]++;
            return;
        }
    
        
        
        backTrack(arr,startX,(startX+endX)/2,startY,(startY+endY)/2);
        backTrack(arr,startX,(startX+endX)/2,(startY+endY)/2+1,endY);
        backTrack(arr,(startX+endX)/2+1,endX,startY,(startY+endY)/2);
        backTrack(arr,(startX+endX)/2+1,endX,(startY+endY)/2+1,endY);
        
        
        
        
        
        
    }
}
