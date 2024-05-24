import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String first = sc.next();
            String second = sc.next();
            String[] hole = new String[3];
            hole[0] = "CEFGHIJKLMNSTUVWXYZ";
            hole[1] = "ADOPQR";
            hole[2] = "B";
            
            String answer = "SAME";
            if(first.length() == second.length()) {
                for(int i = 0; i < 3; i++) {
                    for(String str : hole[i].split("")) {
                        first = first.replaceAll(str, "-");
                        second = second.replaceAll(str, "-");
                    }

                    for(int j = 0; j < first.length(); j++) {
                        if(first.charAt(j) == '-' || second.charAt(j) == '-') {
                            if(first.charAt(j) != second.charAt(j)) {
                                answer = "DIFF";
                                break;
                            }
                        }
                    }

                    if(answer.equals("DIFF")) {
                        break;
                    }
                }
            } else {
          		answer = "DIFF";
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}
