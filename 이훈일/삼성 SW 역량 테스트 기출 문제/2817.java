import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    
    static int N, K, count;
    static int[] arr;
    
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
            K = sc.nextInt();
            arr = new int[N];
            for(int i = 0; i < N; i++) {
            	arr[i] = sc.nextInt();
            }
            count = 0;
            solve(0,0);
            System.out.println("#" + test_case + " " + count);
		}
	}
    
    static void solve(int idx, int sum) {
        if(idx == N) {
        	if(sum == K) {
            	count++;
            }
            return;
        }
        solve(idx+1, sum);
      	sum += arr[idx];
        solve(idx+1, sum);
    }
}
