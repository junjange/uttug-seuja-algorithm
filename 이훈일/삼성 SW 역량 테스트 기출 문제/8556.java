import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String sentence = sc.next();
            sentence = sentence.replaceAll("north", "n");
            sentence = sentence.replaceAll("west", "w");
            
            int dir = 0;
            int len = sentence.length();
            if(sentence.charAt(len - 1) == 'w') {
            	dir = 90 * (int) Math.pow(2, len - 1);
            }
            
            String result = "";
            if(len > 1) {
            	for(int i = len - 2; i >= 0; i--) {
            		if(sentence.charAt(i) == 'n') {
                		dir -= 90 * Math.pow(2, i);
                	} else {
                		dir += 90 * Math.pow(2, i);
                	}
            	}
                
                if(len <= 2) {
                    result = result + (dir / 2);
                } else {
                	result = result + (dir / 2) + "/" + (int) Math.pow(2, len - 2);
                }
            } else {
            	result += dir;
            }
            
            System.out.println("#" + test_case + " " + result);
		}
	}
}
