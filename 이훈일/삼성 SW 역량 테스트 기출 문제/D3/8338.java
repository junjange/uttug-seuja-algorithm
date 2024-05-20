import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static int N, max;
    static int[] num;
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
            num = new int[N];
            for(int i = 0; i < N; i++) {
            	num[i] = sc.nextInt();
            }
            
            max = 0;
            dfs(0, 0);
            
            System.out.println("#" + test_case + " " + max);
		}
	}
    
    public static void dfs(int depth, int sum) {
    	if(depth == N) {
            max = Math.max(max, sum);
        	return;
        }
        
        dfs(depth+1, sum + num[depth]);
        dfs(depth+1, sum * num[depth]);
    }
}
