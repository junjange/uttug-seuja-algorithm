package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1446 {
    static int N, D;
    static HashMap<int[], Integer> graph;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int shortDis = Integer.parseInt(st.nextToken());

            if(end <= D && end-start > shortDis) {
                int[] shortCutInfo = new int[]{start, end};

                if(graph.containsKey(shortCutInfo)) {
                    shortDis = Math.max(shortDis, graph.get(shortCutInfo));
                }

                graph.put(shortCutInfo, shortDis);
            }
        }

        answer = Integer.MAX_VALUE;
        dfs(0, 0, 0);

        System.out.println(answer);
    }

    public static void dfs(int pre, int shortSum, int disSum) {
        List<int[]> keys = new ArrayList<>(graph.keySet());

        for(int i = 0; i < keys.size(); i++) {
            int[] key = keys.get(i);
            int start = key[0];
            int end = key[1];
            if(start >= pre) {
                dfs(end, shortSum + graph.get(key), disSum + (end - start));
            }
        }

        answer = Math.min((D - disSum) + shortSum, answer);
    }
}
