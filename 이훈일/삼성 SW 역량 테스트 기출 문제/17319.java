import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
           	String str = sc.next();
            
            String result = "";
            if(N % 2 == 0) {
                String s1 = str.substring(0, N / 2);
                String s2 = str.substring(N / 2, N);
                if(s1.equals(s2)) {
                	result = "Yes";
                } else {
                	result = "No";
                }
            } else {
            	result = "No";
            }
            
            System.out.println("#" + test_case + " " + result);
		}
	}
}
