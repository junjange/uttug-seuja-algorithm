import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
            int caseNum = sc.nextInt();
            
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < 1000; i++) {
                int score = sc.nextInt();
            	if(map.containsKey(score)) {
                	map.put(score, map.get(score) + 1);
                }else {
               		map.put(score, 1);
                }
            }
            
            List<Integer> keySet = new ArrayList<>(map.keySet());
            keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
            int maxNum = keySet.get(0);
            for(int i = 1; i < keySet.size(); i++) {
            	if(map.get(keySet.get(i-1)) == map.get(keySet.get(i))) {
                	maxNum = Math.max(keySet.get(i-1), keySet.get(i));
                }else {
                	break;
                }
            }
            
            System.out.println("#" + caseNum + " " + maxNum);
		}
	}
}
