package com.example.codingtest.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15661 {

    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n= Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n];

        for (int i=0; i<n; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for (int i=1; i<=n/2; i++) {
            backTracking(0,i,0);

            if (min == 0){
                break;
            }

        }

        System.out.println(min);


    }

    static void backTracking(int depth, int m, int start) {

        if (depth == m) {
            getResult();
            return;
        }

        for (int i=start; i<n; i++) {

            if (!visited[i]) {
                visited[i] = true;
                backTracking(depth+1,m,i+1);
                visited[i] = false;
            }

        }
    }

    static void getResult() {

        int teamA = 0;
        int teamB = 0;

        for (int i=0; i < n; i++) {

            for (int j=0; j < n; j++) {

                if (i == j) {
                    continue;
                }

                if (visited[i] && visited[j]) {
                    teamA += arr[i][j];

                }else if(!visited[i] && !visited[j]){
                    teamB += arr[i][j];
                }

            }

        }

        int abs = Math.abs(teamA - teamB);

        if (abs == 0) {
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(abs,min);

    }
}
