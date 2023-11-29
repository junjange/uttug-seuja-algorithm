package com.example.codingtest.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek2606 {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int n;
    static int result;


    public static void main(String[] args) {

        // 아이디어
        // 2중 for문을 만들고 돌린다. 1에서 dfs를 돌리면서 dfs가 한번 돌때 마다 count++를 해준다

        // 시간 복잡도
        // dfs(vertex+edge) --> 100*100 + 100*100*100 <1억

        //visited

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int num = sc.nextInt();
        arr = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<num; i++){

            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            arr[node1].add(node2);
            arr[node2].add(node1);

        }
        result = 0;
        visited[1] = true;
        dfs(1);

        System.out.println(result-1);


    }

    public static void dfs(int vertex){

        result++;

        ArrayList<Integer> next = arr[vertex];

        for(int i=0; i<next.size(); i++){

            int node = next.get(i);

            if (!visited[node]){
                visited[node]=true;
                dfs(node);
            }
        }

    }
}
