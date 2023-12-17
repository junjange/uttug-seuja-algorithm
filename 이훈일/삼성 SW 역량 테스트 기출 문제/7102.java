import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
            int M = sc.nextInt();
            
            int[] arr = new int[N+M+1];
            for(int i = 1; i <= N; i++) {
            	for(int j = 1; j <= M; j++) {
                	arr[i+j]++;
                }
            }
            
            int max = 0;
            for(int i : arr) {
            	max = Math.max(max, i);
            }
            
           	String answer = "#" + test_case;
            for(int i = 2; i < arr.length; i++) {
            	if(max == arr[i]) {
              	  answer = answer + " " + i;
                }
            }
            
            System.out.println(answer);
		}
	}
}
