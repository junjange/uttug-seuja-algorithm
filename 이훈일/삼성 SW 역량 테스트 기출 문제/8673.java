import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int K = sc.nextInt();
            int[] arr = new int[(int)Math.pow(2,K)];
            for(int i = 0; i < Math.pow(2, K); i++) {
            	arr[i] = sc.nextInt();
            }
            
            int answer = 0;
            while(K > 0) {
                int range = (int)Math.pow(2, K);
                int newRange = (int)Math.pow(2,K-1);
                int[] newArr = new int[newRange];
            	for(int i = 1; i < range; i += 2) {
                	answer += Math.abs(arr[i] - arr[i-1]);
                    newArr[i/2] = Math.max(arr[i], arr[i-1]);
                }
                K--;
                arr = newArr; 
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}
