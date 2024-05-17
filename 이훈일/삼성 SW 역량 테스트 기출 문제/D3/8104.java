import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int K = sc.nextInt();
            int num = 1;
            int sum = 0;
            while(num <= N) {
            	sum += K * num - ((K-1) * (num % 2));
                num++;
            }
            
            StringBuilder sb = new StringBuilder();
            if(N % 2 == 0) {
            	for(int i = 0; i < K; i++) {
                	sb. append(" " + sum);
                }
            } else {
            	for(int i = 0; i < K; i++) {
                	sb. append(" " + sum);
                    sum++;
                }
            }
            
            System.out.println("#" + test_case + sb.toString());
		}
	}
}
