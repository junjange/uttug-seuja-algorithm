import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String D = sc.next();
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            boolean[] num = new boolean[B];
            num[0] = true;
            int count = 0;
            for(int i = 2; i <= B; i++) {
            	if(!num[i-1]) {
                    String strNum = String.valueOf(i);
                    if(strNum.contains(D) && A <= i) {
                    	count++;
                    }
                    
                    for(int j = i-1; j < B; j += i) {
                    	num[j] = true;
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + count);
		}
	}
}
