import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        
        int[][] arr = new int[book_time.length][2]; 
        
        for(int i=0; i<book_time.length; i++){
            
            int start =  Integer.parseInt(book_time[i][0].replace(":","")); 
            int end =  Integer.parseInt(book_time[i][1].replace(":","")); 
        
            end+=10;
            if( end %100 >=60){
                end+=40;
            }
            
            arr[i][0] = start;
            arr[i][1] = end;
            
            
        }
        
        Arrays.sort(arr,new Comparator<>(){
            
            @Override
            public int compare(int[] o1,int[] o2){
                
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }
                
                return o1[0] - o2[0];
            }
        });
        
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i=0; i<arr.length; i++){
            
            if(queue.size() == 0){
                queue.offer(arr[i][1]);
                continue;
            }
            
            int peekEnd = queue.peek();
            
            if(peekEnd <= arr[i][0]){
                queue.poll();
                queue.offer(arr[i][1]);
            }else{
                queue.offer(arr[i][1]);
            }
            
        
            
        }
        
        return queue.size();
    }
}
