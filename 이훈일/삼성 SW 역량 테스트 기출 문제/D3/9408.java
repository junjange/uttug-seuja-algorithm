import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
    static String[] words, sets;
    static int current, count, N;
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
            words = new String[N];
            for(int i = 0; i < N; i++) {
            	words[i] = sc.next();
            }
            
            count = 0;
            for(int i = 1; i <= N; i++) {
                current = i;
                sets = new String[i];
            	dfs(0, 0);
            }
            
            System.out.println("#" + test_case + " " + count);
		}
	}
    
    public static void dfs(int depth, int start) {
    	if(depth == current) {
        	HashSet<Character> hashSet = new HashSet<>();
            for(String word : sets) {
            	for(int i = 0; i < word.length(); i++) {
                	hashSet.add(word.charAt(i));
                }
            }  
            if(hashSet.size() == 26) {
            	count++;
            }
            return;
        }
        
        for(int i = start; i < N; i++) {
            sets[depth] = words[i];
            dfs(depth+1, i+1);
        }
    }
}
