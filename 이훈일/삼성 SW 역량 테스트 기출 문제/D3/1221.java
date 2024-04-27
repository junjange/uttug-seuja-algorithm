import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<String, Integer>() {{
    	put("ZRO", 0);
        put("ONE", 1);
        put("TWO", 2);
        put("THR", 3);
        put("FOR", 4);
        put("FIV", 5);
        put("SIX", 6);
        put("SVN", 7);
        put("EGT", 8);
        put("NIN", 9);
    }};
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String prefix = sc.next();
            int N = sc.nextInt();
            String[] nums = new String[N];
            for(int i = 0; i < N; i++) {
            	nums[i] = sc.next();
            }
            
            Arrays.sort(nums, new Comparator<String>(){
            	@Override
                public int compare(String o1, String o2) {
                	return map.get(o1) - map.get(o2);
                }
            });
            
            StringBuilder sb = new StringBuilder();
            for(String num : nums) {
            	sb.append(" " + num); 
            }
            
            System.out.println(prefix + sb.toString());
		}
	}
}
