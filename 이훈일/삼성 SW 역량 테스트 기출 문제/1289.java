import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();
		
		for(int test_case = 1; test_case <= T; test_case++) {
            String bitValue = sc.nextLine();
            String[] bitArr = bitValue.split("");
            int count = 0;
            
            if(bitArr[0].equals("1")) {
            	count++;
            }
            
            for(int i = 1; i < bitArr.length; i++) {
            	if(!bitArr[i].equals(bitArr[i-1])) {
                	count++;
                }
            }
            
            System.out.println("#" + test_case + " " + count);
		}
	}
}
