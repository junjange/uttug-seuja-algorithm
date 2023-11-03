import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
        
		for(int test_case = 1; test_case <= T; test_case++) {
			int testNum = sc.nextInt();
            String word = sc.next();
            String sentence = sc.next();
            
            String replaceSentence = sentence.replaceAll(word, "");
            int difference = sentence.length() - replaceSentence.length();
            String answer = "#" + testNum + " ";
            if(difference == 0) {
            	answer += "0";
            } else {
            	answer += difference/word.length();
            }
            
            System.out.println("#" + testNum + " " + answer);
		}
	}
}
