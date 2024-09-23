package com.example.codingtest.prim;

import java.io.*;
import java.util.*;


public class Baek1197 {

    static int v;
    static int e;
    static boolean[] visited;
    static int[] minArr;
    static List<Edge>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        visited = new boolean[v+1];
        minArr = new int[v+1];
        list = new ArrayList[v+1];

        for (int i=1; i<=v; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i= 0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b,w));
            list[b].add(new Edge(a,w));
        }

        // 민 arr 초기화
        Arrays.fill(minArr,Integer.MAX_VALUE);
        minArr[1] = 0;
        long cnt = 0;

        for (int i=1; i<=v; i++) {

            int min = Integer.MAX_VALUE;
            int vertex = -1;

            for (int j=1; j <=v; j++) {

                if (visited[j]) {
                    continue;
                }

                if (min > minArr[j]) {
                    min = minArr[j];
                    vertex = j;
                }
            }

            if (vertex ==-1) {
                break;
            }

            visited[vertex] = true;
            cnt += min;

            List<Edge> edges = list[vertex];

            for (int j = 0; j <edges.size(); j++ ) {

                Edge edge = edges.get(j);

                if (!visited[edge.to] && minArr[edge.to] > edge.wight) {
                    minArr[edge.to] = edge.wight;
                }

            }

        }

        System.out.println(cnt);



    }

    static class Edge {
        public int to;
        public int wight;

        public Edge(int to, int wight) {
            this.to = to;
            this.wight = wight;
        }
    }
}
