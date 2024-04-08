package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek18429 {

    static int n,k,cnt;
    static int[] arr;
    static boolean[] visited;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(0,500);


        System.out.println(cnt);





    }
    public static void backTracking(int depth, int work){

        if(depth == n){
            cnt++;
            return;
        }

        if(work < 500){
            return;
        }

        for (int i=0; i<n; i++) {

            if(!visited[i]){
                visited[i] = true;
                backTracking(depth+1,work + arr[i] - k);
                visited[i] = false;
            }
        }

    }
}
