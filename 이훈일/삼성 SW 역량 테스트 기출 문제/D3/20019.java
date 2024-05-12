import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		 Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String word = sc.next();
            String front = word.substring(0, word.length()/2);
            String back = word.substring(word.length()/2+1);
            
            StringBuilder frontSB = new StringBuilder(front);
            StringBuilder backSB = new StringBuilder(back);
            
            String answer = "";
            if(frontSB.toString().equals(backSB.toString()) && 
               frontSB.toString().equals(frontSB.reverse().toString()) &&
               backSB.toString().equals(backSB.reverse().toString())) {
            	answer = "YES";
            } else {
            	answer = "NO";
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}
