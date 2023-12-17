package com.example.codingtest.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek11724 {

    static ArrayList<Integer>[] arr;

    static boolean[] visited;

    static int N,M;



    public static void main(String[] args) {

        // 아이디어
        // 2중 포문으로 만든다음 돌면서 방문 하지 않은 노드를 방문 처리 후 dfs를 돌고 dfs 가 끝나는 시점에 cnt++

        //시간 복잡도
        // dfs(1000*1000+ 1000*1000*)


        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int cnt = 0;

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            arr[node1].add(node2);
            arr[node2].add(node1);
        }

        for (int i=1; i<=N; i++){

            if (!visited[i]){
                visited[i] = true;
                dfs(i);
                cnt++;

            }

        }

        System.out.println(cnt);


    }

    public static void dfs(int node){

        ArrayList<Integer> list = arr[node];

        for(int i=0; i<list.size(); i++){

            Integer ndoes = list.get(i);

            if(!visited[ndoes]){
                visited[ndoes] = true;
                dfs(ndoes);

            }
        }

    }

}
