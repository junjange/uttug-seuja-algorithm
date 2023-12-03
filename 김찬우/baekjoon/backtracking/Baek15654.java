package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek15654 {

    static int[] arr;
    static boolean[] visited;

    static int[] result;

    static int n,m;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 아이디어
        // arr[] 리스트를 만들고 재귀함수를 통해서

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        rec(0);
        System.out.println(sb);

    }

    public static void rec(int depth){


        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){

            if(!visited[i]){
                visited[i] = true;
                result[depth] = arr[i];
                rec(depth+1);
                visited[i] =false;

            }
        }

    }
}
