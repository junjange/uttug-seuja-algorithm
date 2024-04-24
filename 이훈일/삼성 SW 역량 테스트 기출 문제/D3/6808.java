import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
    static int[] aCards, bCards, results;
    static boolean[] visited;
    static int win, lose;
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			aCards = new int[9];
            visited = new boolean[9];
            for(int i = 0; i < 9; i++) {
            	aCards[i] = sc.nextInt();
            }
            
            bCards = new int[9];
            int bIndex = 0;
            int num = 1;
            while(num <= 18) {
                boolean isIn = false;
                for(int i = 0; i < 9; i++) {
                	if(num == aCards[i]) {
                		isIn = true;    	
                        break;
                    }
                }
                
                if(!isIn) {
                	bCards[bIndex] = num;
                    bIndex++;
                }
               
                num++;
            }
            
            results = new int[9];
            win = 0;
            lose = 0;
            dfs(0);
            
            System.out.println("#" + test_case + " " + win + " " + lose);
		}
	}
    
    public static void dfs(int depth) {
    	if(depth == 9) {
            int aPoint = 0;
            int bPoint = 0;
           	for(int i = 0; i < 9; i++) {
            	if(aCards[i] > results[i]) {
                	aPoint += aCards[i] + results[i];
                } else if(aCards[i] < results[i]) {
                	bPoint += aCards[i] + results[i];
                }
            }
            
            if(aPoint > bPoint) {
            	win++;
            } else if (aPoint < bPoint){
            	lose++;
            }
            
            return;
        }
        
        for(int i = 0; i < 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                results[depth] = bCards[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
