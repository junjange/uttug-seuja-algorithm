package com.example.codingtest.remind.dfs;

import java.io.*;
import java.util.*;

public class Baek1260 {

    static ArrayList<Integer>[] arr;

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i=1; i <=n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i=1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);

        }

        //dfs(start);
        //System.out.println(sb.toString());
        //sb.setLength(0);

        for (int i=1; i<=n; i++) {
            for (int j=0; j < arr[i].size(); j++) {
                System.out.print(arr[i].get(j)+" ");
            }
            System.out.println();
        }

        visited = new boolean[n+1];
        bfs(start);
        System.out.println(sb.toString());
    }

    static void dfs(int start) {

        visited[start] = true;

        sb.append(start).append(" ");

        for (int i=0; i < arr[start].size(); i++) {

            if (!visited[arr[start].get(i)]) {
                dfs(arr[start].get(i));
            }

        }


    }

    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            sb.append(node).append(" ");

            for (int i=0; i < arr[node].size(); i++) {

                if (!visited[arr[node].get(i)]) {
                    queue.offer(arr[node].get(i));
                    visited[arr[node].get(i)] = true;
                }
            }


        }


    }
}
