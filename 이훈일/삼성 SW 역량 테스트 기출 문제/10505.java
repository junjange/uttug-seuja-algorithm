import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int sum = 0;
            int[] arr = new int[N];
            double avg;
            int count = 0;
            for(int i = 0; i < N; i++) {
            	int num = sc.nextInt();
                arr[i] = num;
                sum += num;
            }
            avg = sum/N;
            for(int num : arr) {
            	if(num <= avg) {
                	count++;
                }
            }
            System.out.println("#" + test_case + " " + count);
		}
	}
}
