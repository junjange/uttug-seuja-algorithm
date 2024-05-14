import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
    static int N, L, max;
    static int[][] material;
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
            L = sc.nextInt();
            material = new int[N][2];
            for(int i = 0; i < N; i++) {
            	material[i][0] = sc.nextInt();
                material[i][1] = sc.nextInt();
            }
            
            max = 0;
            dfs(0, 0, 0);
            
            System.out.println("#" + test_case + " " + max);
		}
	}
    
    public static void dfs(int index, int calorie, int score) {
        if(calorie > L) {
        	return;
        } else {
        	max = Math.max(max, score);
        }
        
        if(index == N) {
        	return;
        }
        
        dfs(index + 1, calorie + material[index][1], score + material[index][0]);
        dfs(index + 1, calorie, score);
    }
}
