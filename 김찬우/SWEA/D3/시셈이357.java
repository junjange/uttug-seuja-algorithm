import java.util.*;
import java.io.*;


class Solution
{
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static HashSet<Integer> set;
    
	public static void main(String args[]) throws Exception
	{
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine()," ");
        
		int T = Integer.parseInt(st.nextToken());
	

		for(int test_case = 1; test_case <= T; test_case++)
		{
            
            arr= new int[7];
            visited = new boolean[7];
            result =new int[3];
            set = new HashSet<>();
            
            
            st =  new StringTokenizer(br.readLine()," ");
        
			for (int i=0; i<7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            bfs(0);
            
            ArrayList<Integer> answer =  new ArrayList<>(set);
            Collections.sort(answer, Collections.reverseOrder());
            
            System.out.println("#"+test_case+" "+answer.get(4));
            
            
            

		}
	}
    
    static void bfs(int depth) {
        if (depth == 3) {
            int sum=0;
            
            for (int i=0; i<3; i++) {
                sum+=result[i];
            }
            
            set.add(sum);
            
            return;
        }
        
        for (int i=0; i<7; i++) {
            if(!visited[i]) {
                visited[i] =true;
                result[depth] = arr[i];
                bfs(depth+1);
                visited[i] =false;      
            }
            
            
        }
    }
    
}
