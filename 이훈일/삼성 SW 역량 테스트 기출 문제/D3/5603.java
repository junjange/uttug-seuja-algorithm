import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int[] nums = new int[N];
            int sum = 0;
            for(int i = 0; i < N; i++) {
            	nums[i] = sc.nextInt();
                sum += nums[i];
            }
            
            int answer = 0;
            for(int num : nums) {
            	if(num < sum/N) {
                	answer += sum/N - num;
                }
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}
