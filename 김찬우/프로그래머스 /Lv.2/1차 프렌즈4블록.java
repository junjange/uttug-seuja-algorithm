class Solution {
    
    static char[][] arr;
    static boolean[][] check;
    static int count=0; 
    static boolean end = true;
    public int solution(int m, int n, String[] board) {
        
        // 아이디어
        // 4개씩 터트리는 기능 
        // 아래로 끌어 내리는 기능 
        // 터트릴게 없을 떄 종료
        
        arr =  new char[m][n];
        
        int a = 0; 
        for(String str : board){
            arr[a] = str.toCharArray();
            a++;
        }
    
        while(end){
            
            check = new boolean[m][n];
            end = false;
            checkGame();    
            removeGame();
            fillArr();      
        }
        
    
        return count;
    }
    
    public void checkGame(){
        
        for(int i=0; i< arr.length-1; i++){
            
            for(int j=0; j< arr[i].length-1; j++){
                
                if(arr[i][j] =='0'){
                    continue;
                }
                
                if(arr[i][j] == arr[i+1][j] && 
                  arr[i][j] == arr[i][j+1] &&
                  arr[i][j] == arr[i+1][j+1] ){
                    
                    check[i][j] =true;
                    check[i+1][j] =true;
                    check[i][j+1] =true;
                    check[i+1][j+1] =true;
                    end = true;
                    
                    
                }
                
            }
            
        }
        
    }
    
    public void removeGame(){
        
         for(int i=0; i< arr.length; i++){
            
            for(int j=0; j< arr[i].length; j++){
                
                if(check[i][j]){
                    arr[i][j] = '0';
                    count++;
                }
                    
            }
                
        }
            
    }
    
    public void fillArr(){
        
        for(int i = arr.length-1; i>0; i--){
            
            for(int j=0; j< arr[i].length; j++){
                
                if(arr[i][j] == '0'){
                    
                    int k = i-1;
                    while(k >= 0){
                        
                        if(arr[k][j] !='0'){
                            arr[i][j] = arr[k][j];
                            arr[k][j] ='0';
                            break;
                        }
                        k--;
                        
                    }
                }
                    
            }
                
        }
        
    }
        
    
}
