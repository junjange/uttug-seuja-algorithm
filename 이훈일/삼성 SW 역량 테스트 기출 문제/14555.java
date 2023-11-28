import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String line = sc.next();
            String[] pasture = line.split("");
            int count = 0;
            for(int i = 0; i < pasture.length; i++) {
            	if(pasture[i].equals("(")) {
                    if(!pasture[i+1].equals(")")) {
                    	count++;
                    }
                }
                if(pasture[i].equals(")")) {
                    count++;
                }
            }
            
            System.out.println("#" + test_case + " " + count);
		}
	}
}
