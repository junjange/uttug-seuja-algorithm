import java.util.*;
import java.lang.Math;

class Solution {
    static int[][] arr; 
    static ArrayList<Integer> list = new ArrayList<>(); 
    static int dx[] = {0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    public int[] solution(int rows, int columns, int[][] queries) {
        
        
        arr = new int[rows][columns];
        int v =1;
        for (int i=0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                
                arr[i][j] = v++;
                
            }
            
        }
        
        for (int[] ar : queries){
             spin(ar[0]-1,ar[1]-1,ar[2]-1,ar[3]-1);
        }
        
        int[] answer = new int[queries.length];
        
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        

        
        return answer;
    }
    static void spin(int x1, int y1, int x2, int y2) {
        
        int d = 0;
        int startX = x1;
        int startY = y1;
        int temp = arr[startX][startY];
        int min = Integer.MAX_VALUE;
        
        while (true) {
            
            int nx = startX + dx[d];
            int ny = startY + dy[d];
            
            if (ny > y2 || ny < y1 || nx > x2 || nx < x1) {
                d = (d+1) % 4; 
                continue;
            }

            
            min = Math.min(min,temp);
            
            int tem2 = arr[nx][ny];
            arr[nx][ny] = temp;
            temp = tem2;    
            
            startX = nx;
            startY = ny;

        
    
            if (startX == x1 && startY == y1) {
                break;
            }

        }
        
        list.add(min);

    }
}
