package com.example.codingtest.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2644 {

    static int n;
    static int result1;
    static int result2;
    static int m;
    static ArrayList<Integer>[] graph;

    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        visited = new int[n+1];
        graph = new ArrayList[n+1];

        for(int i=1; i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        result1 = Integer.parseInt(st.nextToken());
        result2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            graph[parent].add(child);
            graph[child].add(parent);
        }

        bfs(result1);

        int answer = visited[result2];

        if (answer==0){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }




    }


    public static void bfs(int node){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){

            Integer pollNode = queue.poll();

            if(pollNode == result2){
                break;
            }

            for(int i=0; i<graph[pollNode].size(); i++){

                int no = graph[pollNode].get(i);

                if(visited[no]==0){
                    visited[no] = visited[pollNode]+1;
                    queue.add(no);
                }

            }

        }

    }
}
