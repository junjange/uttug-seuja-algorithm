
import java.io.*;
import java.util.*;

public class Solution {
    static int[][] map;
    static int n,start;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static int max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case= 1; test_case <=10; test_case++) {

            visited = new boolean[101];
            map = new int[101][101];
            max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            start = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i=0; i < n/2; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                map[a][b] = 1;
            }
            bfs(start);
            System.out.println("#"+test_case+" "+max);
        }
    }

    static void bfs (int startNode) {

        visited[startNode] = true;
        Queue<Integer> queue =  new ArrayDeque<>();
        queue.add(startNode);
        list.add(startNode);

        while (!queue.isEmpty()) {
            int len  = queue.size();
            list.clear();
            for (int i = 0; i < len; i++) {
                Integer node = queue.poll();
                for (int j=1; j<=100; j++) {
                    if (map[node][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                        list.add(j);
                    }
                }
            }
            if (!list.isEmpty()){
                max = Collections.max(list);
            }
        }
    }
}
