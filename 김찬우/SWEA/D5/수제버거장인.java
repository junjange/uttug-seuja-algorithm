
import java.io.*;
import java.util.*;

public class Solution {

    static int n,m,cnt;
    static ArrayList<int[]> list  =new ArrayList<>();
    static boolean[] visited;
    static ArrayList<Integer> ham = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int test =1; test <=T; test++) {

            list.clear();

            st = new StringTokenizer(br.readLine());

            n= Integer.parseInt(st.nextToken());
            m= Integer.parseInt(st.nextToken());
            cnt = 0;

            visited = new boolean[n+1];

            for (int i=0; i<m; i++) {

                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.add(new int[]{a,b});

            }

            back(1);
            System.out.println("#"+test+" "+cnt);


        }

    }

    static void back(int depth) {

        if (depth == n+1) {

            for (int[] node : list) {
                if (visited[node[0]] && visited[node[1]]) {
                    return;
                }
            }


            cnt++;

            return;
        }

        visited[depth] = true;
        back(depth+1);
        visited[depth] = false;
        back(depth+1);

    }
}
