import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++) {
			String line = sc.next();
            HashMap<String, boolean[]> cards = new HashMap<String, boolean[]>(){{
            	put("S", new boolean[13]);
                put("C", new boolean[13]);
                put("H", new boolean[13]);
                put("D", new boolean[13]);
            }};
           
            boolean isPossible = true;
            for(int i = 0; i < line.length(); i += 3) {
            	String sub = line.substring(i, i+3);
                String type = String.valueOf(sub.charAt(0));
                int num = Integer.valueOf(sub.substring(1, 3));
                if(cards.get(type)[num-1]) {
                	isPossible = false;
                    break;
                } else {
                	boolean[] cardsCalled = cards.get(type);
                    cardsCalled[num-1] = true;
                    cards.put(type, cardsCalled);
                }
            }
            
            String answer = "";
            String[] types = new String[]{"S", "D", "H", "C"};
            if(isPossible) {
            	for(String key : types) {
                    int count = 0;
                	for(boolean isCalled : cards.get(key)) {
                    	if(!isCalled) {
                        	count++;
                        }
                    }
                    answer += count+" ";
                }
            } else {
            	answer = "ERROR";
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}
