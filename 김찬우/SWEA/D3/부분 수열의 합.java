import java.util.*;
import java.io.*;


class Solution
{
    static int n,k,cnt;
    static int[] arr;
    static boolean[] visited;
    static int[] result;

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];
            visited = new boolean[n];
            result = new int[20];
            cnt = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i=1; i<=n; i++) {
                back(0,i,0);
            }

            System.out.println("#"+test_case+" "+ cnt);

        }
    }

    static void back(int depth, int num, int start) {

        if (depth == num ) {

            int sum = 0;

            for(int i=0; i<n; i++) {
                sum += result[i];
            }


            if (sum == k) {
                cnt++;
            }

            return;
        }

        for (int i= start; i < n; i++) {

            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                back(depth+1, num,i+1);
                visited[i] = false;
            }
        }
    }
}
