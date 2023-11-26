package com.example.codingtest.bfs;

import java.util.*;


public class Baek2606 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {

        // 아이디어
        // int[][] 이차원 배열을 만들어 인접 노드와 간선을 표시한다. bfs를 돌면서 visited == false 일 때 cnt++

        // 시간복잡도
        // bfs(노드 + 간선) -> 100+100*100 ->

        // queue

        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }


        for(int i=0; i<m ;i++){

            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            graph[node1].add(node2);
            graph[node2].add(node1);
        }
        System.out.println(bfs(1));


    }

    public static int bfs(int start){

        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){

            int x = queue.poll();

            for(int i=0; i<graph[x].size(); i++){
                int y = graph[x].get(i);

                if(!visited[y]){
                    queue.offer(y);
                    visited[y] = true;
                    result++;
                }

            }

        }
        return result;

    }
}
