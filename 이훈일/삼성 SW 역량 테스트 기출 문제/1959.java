import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int M = sc.nextInt();
            int[] A = new int[N];
            int[] B = new int[M];
            
            for(int i = 0; i < N; i++) {
            	A[i] = sc.nextInt();
            }
            
           	for(int i = 0; i < M; i++) {
           		B[i] = sc.nextInt();
           	}
            
            int max = Integer.MIN_VALUE;
            if(N < M) {
            	for(int i = 0; i <= M-N; i++) {
                    int sum = 0;
                	for(int j = 0; j < N; j++) {
                  		sum += A[j] * B[j+i];	
                  	}
                    max = Math.max(sum, max);
                }
            } else {
            	for(int i = 0; i <= N-M; i++) {
                	int sum = 0;
                    for(int j = 0; j < M; j++) {
                    	sum += B[j] * A[j+i];
                    }
                    max = Math.max(sum, max);
                }
            }
            
            System.out.println("#" + test_case + " " + max);
		}
	}
}
